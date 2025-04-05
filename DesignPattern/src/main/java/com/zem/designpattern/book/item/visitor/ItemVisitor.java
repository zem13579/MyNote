package com.zem.designpattern.book.item.visitor;

import com.zem.designpattern.book.item.AbstractProductItem;

public interface ItemVisitor<T> {
    T visitor(AbstractProductItem  productItem);
}
