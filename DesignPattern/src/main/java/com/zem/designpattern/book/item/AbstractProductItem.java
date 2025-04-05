package com.zem.designpattern.book.item;

/**
 * @Author zem
 * @Date 2023/11/12
 * @Describe
 */
public abstract class AbstractProductItem {


    protected void addProductItem(AbstractProductItem item) {
        throw new UnsupportedOperationException("not support child add!");
    }

    protected void delProductChild(AbstractProductItem item) {
        throw new UnsupportedOperationException("not support child delete !");
    }


}
