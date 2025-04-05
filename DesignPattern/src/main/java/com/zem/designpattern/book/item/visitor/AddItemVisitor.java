package com.zem.designpattern.book.item.visitor;

import com.zem.designpattern.book.item.AbstractProductItem;
import com.zem.designpattern.book.item.composite.ProductComposite;
import com.zem.designpattern.book.pojo.ProductItem;
import com.zem.designpattern.book.utils.RedisCommonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zem.designpattern.book.service.ProductItemService.ITEMS;

/**
 * @Author zem
 * @Date 2023/11/18
 * @Describe
 */
@Component
public class AddItemVisitor implements ItemVisitor<AbstractProductItem> {


    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Override
    public AbstractProductItem visitor(AbstractProductItem productItem) {
        ProductComposite currentItem = (ProductComposite)redisCommonProcessor.get(ITEMS);
        ProductComposite addItem = (ProductComposite) productItem;
        if(addItem.getPid().equals(currentItem.getId())){
            currentItem.addProductItem(addItem);
            return currentItem;
        }
        addChild(addItem,currentItem);
        return currentItem;
    }

    private void addChild(ProductComposite addItem, ProductComposite currentItem) {
        for (AbstractProductItem abstractProductItem : currentItem.getChild()) {
            ProductComposite productComposite = (ProductComposite) abstractProductItem;
            if(addItem.getPid().equals(productComposite.getId())){
                productComposite.addProductItem(addItem);
                break;
            }
            addChild(addItem,productComposite);
        }
    }
}
