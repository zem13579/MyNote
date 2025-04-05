package com.zem.designpattern.book.item.composite;

import com.zem.designpattern.book.item.AbstractProductItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author zem
 * @Date 2023/11/12
 * @Describe
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log
public class ProductComposite extends AbstractProductItem {

    private Integer id;
    private Integer pid;
    private String name;
    private List<AbstractProductItem> child = new ArrayList<>();

    @Override
    public void addProductItem(AbstractProductItem item) {
        this.child.add(item);
    }

    @Override
    public void delProductChild(AbstractProductItem item) {

        if(item instanceof ProductComposite removeItem){
            boolean removeSuccess = false;
            Iterator<AbstractProductItem> iterator = child.iterator();
            while (iterator.hasNext()){
                if(iterator.next() instanceof ProductComposite composite){
                    if(removeItem.getId() == composite.getId()){
                        iterator.remove();
                        removeSuccess = true;
                        break;
                    }
                }
            }
            if(!removeSuccess){
             log.warning("remove failed ! no matched item");
            }
        }else{
            throw new IllegalArgumentException("item is not instanceof ProductComposite !");
        }
    }
}
