package com.zem.designpattern.deprecated.state;

import com.zem.designpattern.book.utils.RedisCommonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedReceiveOrderState extends DeprecatedAbstractOrderState {
    @Autowired
    private RedisCommonProcessor redisCommonProcessor;

    @Override
    protected DeprecatedOrder receiveOrder(String orderId, DeprecatedOrderContext context) {
        DeprecatedOrder deprecatedOrder = (DeprecatedOrder) redisCommonProcessor.get(orderId);
        if (!deprecatedOrder.getState().equals(ORDER_WAIT_RECEIVE)) {
            throw new UnsupportedOperationException("order state should be ORDER_WAIT_RECEIVE");
        }
        //支付逻辑
        //支付完成后，修改订单状态为待发货，并更新redis 缓存
        deprecatedOrder.setState(ORDER_FINISH);
        redisCommonProcessor.remove(orderId);
        return deprecatedOrder;
    }
}
