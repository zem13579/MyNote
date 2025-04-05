package com.zem.designpattern.book.service;

import com.zem.designpattern.deprecated.state.DeprecatedOrder;
import com.zem.designpattern.deprecated.state.DeprecatedOrderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2023/11/27 0027
 */
@Service
public class DeprecatedOrderService {

    @Autowired
    private DeprecatedOrderContext context;

    public DeprecatedOrder createOrder(String productId){
        String orderId = "OID" + productId;
        return context.createOrder(orderId,productId);
    }

    public DeprecatedOrder payOrder(String orderId){
        return context.payOrder(orderId);
    }

    public DeprecatedOrder sendOrder(String orderId){
        return context.sendOrder(orderId);
    }

    public DeprecatedOrder receiveOrder(String orderId){
        return context.receiveOrder(orderId);
    }

}
