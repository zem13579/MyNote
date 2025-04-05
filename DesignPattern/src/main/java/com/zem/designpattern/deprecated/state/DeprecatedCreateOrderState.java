package com.zem.designpattern.deprecated.state;

import com.zem.designpattern.book.utils.RedisCommonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedCreateOrderState extends DeprecatedAbstractOrderState {
    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Autowired
    private DeprecatedPayOrderState deprecatedPayOrderState;

    @Override
    protected DeprecatedOrder createOrder(String orderId, String productId, DeprecatedOrderContext context) {
        DeprecatedOrder order = DeprecatedOrder.builder().OrderId(orderId).productId(productId).state(ORDER_WAIT_PAY).build();
        redisCommonProcessor.set(orderId, order, 900);
        context.setCurrentState(this.deprecatedPayOrderState);
        return order;
    }
}
