package com.zem.designpattern.book.service;

import com.alibaba.fastjson.JSONObject;
import com.zem.designpattern.book.item.composite.ProductComposite;
import com.zem.designpattern.book.pojo.ProductItem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


class ProductItemServiceTest {

    @Test
    void fetchAllItems() {
        String json = "[{\"id\":1,\"name\":\"商城\",\"pid\":0},{\"id\":2,\"name\":\"电脑\",\"pid\":1},{\"id\":3,\"name\":\"书籍\",\"pid\":1},{\"id\":4,\"name\":\"台式电脑\",\"pid\":2},{\"id\":5,\"name\":\"笔记本电脑\",\"pid\":2},{\"id\":6,\"name\":\"游戏电脑\",\"pid\":4},{\"id\":7,\"name\":\"办公电脑\",\"pid\":4},{\"id\":8,\"name\":\"教育类\",\"pid\":3},{\"id\":9,\"name\":\"科普类\",\"pid\":3},{\"id\":10,\"name\":\"九年义务教育书籍\",\"pid\":8}]";
        List<ProductItem> list = JSONObject.parseArray(json, ProductItem.class);
        ProductItemService productItemService = new ProductItemService();

        productItemService.generateProductTree(list);
    }
}