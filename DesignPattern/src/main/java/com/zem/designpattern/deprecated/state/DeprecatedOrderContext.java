package com.zem.designpattern.deprecated.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedOrderContext {
    private DeprecatedAbstractOrderState currentState;

    @Autowired
    private DeprecatedCreateOrderState deprecatedCreateOrder;


    public void setCurrentState(DeprecatedAbstractOrderState currentState) {
        this.currentState = currentState;
    }

    public DeprecatedOrder createOrder(String orderId, String productId) {
        this.currentState = deprecatedCreateOrder;
        DeprecatedOrder order = currentState.createOrder(orderId, productId, this);
        return order;
    }

    public DeprecatedOrder payOrder(String orderID){
        return currentState.sendOrder(orderID, this);
    }

    public DeprecatedOrder sendOrder(String orderID){
        return currentState.sendOrder(orderID, this);
    }

    public DeprecatedOrder receiveOrder(String orderID){
        return currentState.receiveOrder(orderID, this);
    }


}
