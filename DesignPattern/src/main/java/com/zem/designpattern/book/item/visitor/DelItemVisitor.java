package com.zem.designpattern.book.item.visitor;

import com.zem.designpattern.book.item.AbstractProductItem;
import com.zem.designpattern.book.item.composite.ProductComposite;
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
public class DelItemVisitor implements ItemVisitor<AbstractProductItem>{

    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Override
    public AbstractProductItem visitor(AbstractProductItem productItem) {
        //从redids 中获取
        ProductComposite currentItem = (ProductComposite)redisCommonProcessor.get(ITEMS);

        ProductComposite delItem = (ProductComposite) productItem;
        if(currentItem.getId().equals(delItem.getId())){
            throw new UnsupportedOperationException("根节点不能删除");
        }
        //如果被删除的节点的父节点为当前节点，则直接删除
        if(currentItem.getId().equals(delItem.getPid())){
            currentItem.delProductChild(delItem);
            return currentItem;
        }
        delChild(currentItem,delItem);
        return currentItem;
    }

    private void delChild(ProductComposite currentItem, ProductComposite delItem) {
        for (AbstractProductItem abstractProductItem : currentItem.getChild()) {
            ProductComposite item = (ProductComposite) abstractProductItem;
            if(item.getId().equals(delItem.getPid())){
                item.delProductChild(delItem);
                break;
            }else{
                delChild(item,delItem);
            }
        }
    }
}
