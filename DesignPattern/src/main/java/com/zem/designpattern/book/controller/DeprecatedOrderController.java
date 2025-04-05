package com.zem.designpattern.book.controller;

import com.zem.designpattern.book.service.DeprecatedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2023/11/27 0027
 */
@RestController
@RequestMapping("/deprecated/order")
public class DeprecatedOrderController {

    @Autowired
    private DeprecatedOrderService orderService;



}
