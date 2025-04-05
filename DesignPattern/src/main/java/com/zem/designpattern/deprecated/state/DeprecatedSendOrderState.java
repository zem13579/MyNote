package com.zem.designpattern.deprecated.state;

import com.zem.designpattern.book.utils.RedisCommonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedSendOrderState extends DeprecatedAbstractOrderState {
    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Autowired
    private DeprecatedReceiveOrderState receiveOrderState;

    @Override
    protected DeprecatedOrder sendOrder(String orderId, DeprecatedOrderContext context) {
        DeprecatedOrder deprecatedOrder = (DeprecatedOrder) redisCommonProcessor.get(orderId);
        if(!deprecatedOrder.getState().equals(ORDER_WAIT_SEND)){
            throw new UnsupportedOperationException("order state should be ORDER_WAIT_SEND");
        }
        //支付逻辑
        //支付完成后，修改订单状态为待发货，并更新redis 缓存
        deprecatedOrder.setState(ORDER_WAIT_RECEIVE);
        redisCommonProcessor.set(orderId,deprecatedOrder);
        context.setCurrentState(this.receiveOrderState);
        return deprecatedOrder;
    }
}
