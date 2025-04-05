package com.zem.designpattern.book.service;

import com.alibaba.fastjson.JSON;
import com.zem.designpattern.book.item.AbstractProductItem;
import com.zem.designpattern.book.item.composite.ProductComposite;
import com.zem.designpattern.book.item.visitor.AddItemVisitor;
import com.zem.designpattern.book.item.visitor.DelItemVisitor;
import com.zem.designpattern.book.pojo.ProductItem;
import com.zem.designpattern.book.repo.ProductItemRepository;
import com.zem.designpattern.book.utils.RedisCommonProcessor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Delayed;
import java.util.stream.Collectors;

/**
 * @Author zem
 * @Date 2023/11/12
 * @Describe
 */
@Service
@Log
@Transactional
public class ProductItemService {
    public static final String ITEMS = "items";
    @Autowired
    private RedisCommonProcessor redisProcessor;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private AddItemVisitor addItemVisitor;

    @Autowired
    private DelItemVisitor delItemVisitor;

    public ProductComposite fetchAllItems() {
        Object cacheItems = redisProcessor.get(ITEMS);
        if (cacheItems != null) {
            if (cacheItems instanceof ProductComposite items) {
                return items;
            } else {
                throw new UnsupportedOperationException("can not be ProductComposite");
            }
        }
        List<ProductItem> fetchDBitems = productItemRepository.findAll();
        log.info(JSON.toJSONString(fetchDBitems));
        ProductComposite items = generateProductTree(fetchDBitems);
        if (items == null) {
            throw new UnsupportedOperationException("item should not be null in db");
        }
        redisProcessor.set(ITEMS, items);
        return items;
    }

    public ProductComposite generateProductTree(List<ProductItem> fetchDBitems) {
        ArrayList<ProductComposite> composites = new ArrayList<>(fetchDBitems.size());
        fetchDBitems.forEach(dbItem -> {
            composites.add(ProductComposite.builder()
                    .id(dbItem.getId())
                    .name(dbItem.getName())
                    .pid(dbItem.getPid())
                    .build());
        });
        Map<Integer, List<ProductComposite>> groupingList = composites.stream().collect(Collectors.groupingBy(ProductComposite::getPid));
        composites.forEach(item -> {
            List<ProductComposite> list = groupingList.get(item.getId());
            item.setChild(list == null ? new ArrayList<>() : list.stream().map(x -> (AbstractProductItem) x).collect(Collectors.toList()));
        });
        return composites.stream().findFirst().orElse(null);
    }

    public ProductComposite addItems(ProductItem item){
        //先更新数据库
        productItemRepository.addItem(item.getName(),item.getPid());
        //通过访问者模式 访问并添加新的商品类目
        ProductComposite addItem = ProductComposite.builder()
                .id(productItemRepository.findProductItemByNameAndPid(item.getName(), item.getPid()).getId())
                .name(item.getName())
                .pid(item.getPid())
                .child(new ArrayList<>())
                .build();
        AbstractProductItem updateedItems = addItemVisitor.visitor(addItem);
        //更新数据库
        redisProcessor.set(ITEMS,updateedItems);
        return (ProductComposite) updateedItems;
    }

    public ProductComposite delItems(ProductItem item){
        //先删除数据库
        productItemRepository.delItem(item.getId(),item.getPid());
        //更新本地模型
        ProductComposite delItem = ProductComposite.builder()
                .id(item.getId())
                .name(item.getName())
                .pid(item.getPid()).build();
        AbstractProductItem updateItem = delItemVisitor.visitor(delItem);
        //更新redis缓存
        redisProcessor.set(ITEMS,updateItem);
        return (ProductComposite) updateItem;
    }
}
