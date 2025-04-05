package com.zem.designpattern.deprecated.state;

import com.zem.designpattern.book.utils.RedisCommonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedPayOrderState extends DeprecatedAbstractOrderState {

    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Autowired
    private DeprecatedSendOrderState sendOrderState;

    @Override
    protected DeprecatedOrder payOrder(String orderId, DeprecatedOrderContext context) {
        DeprecatedOrder deprecatedOrder = (DeprecatedOrder) redisCommonProcessor.get(orderId);
        if(!deprecatedOrder.getState().equals(ORDER_WAIT_PAY)){
            throw new UnsupportedOperationException("order state should be ORDER_WAIT_PAY");
        }
        //支付逻辑
        //支付完成后，修改订单状态为待发货，并更新redis 缓存
        deprecatedOrder.setState(ORDER_WAIT_SEND);
        redisCommonProcessor.set(orderId,deprecatedOrder);
        context.setCurrentState(this.sendOrderState);
        return deprecatedOrder;
    }
}
