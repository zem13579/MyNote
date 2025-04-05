package com.zem.designpattern.book.controller;

import com.zem.designpattern.book.item.composite.ProductComposite;
import com.zem.designpattern.book.pojo.ProductItem;
import com.zem.designpattern.book.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zem
 * @Date 2023/11/12
 * @Describe
 */
@RestController
@RequestMapping("/product")
public class ProductItemController {

    @Autowired
    private ProductItemService productItemService;

    @PostMapping("/fetchAllItems")
    public ProductComposite fetchAllItems(){
        return productItemService.fetchAllItems();
    }

    @PostMapping("/addItem")
    public ProductComposite addItem(@RequestBody ProductItem item){
       return productItemService.addItems(item);
    }

    @PostMapping("/delItem")
    public ProductComposite delItem(@RequestBody ProductItem item){
        return productItemService.delItems(item);
    }

}
