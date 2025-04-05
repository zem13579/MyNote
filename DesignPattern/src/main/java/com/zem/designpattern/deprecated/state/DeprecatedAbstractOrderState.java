package com.zem.designpattern.deprecated.state;

/**
 * 四个类分别实现了四个方法，在contest中引入改类，并再对应的 实现方法中切换context中状态，
 * 由此实现了状态的流转
 * 缺点 再当前spring的开发语境下，会出现并发问题，每个订单需要一哥context
 */
public abstract class DeprecatedAbstractOrderState {
    protected final String ORDER_WAIT_PAY = "ORDER_WAIT_PAY";
    protected final String ORDER_WAIT_SEND = "ORDER_WAIT_SEND";
    protected final String ORDER_WAIT_RECEIVE = "ORDER_WAIT_RECEIVE";
    protected final String ORDER_FINISH = "ORDER_FINISH";

    protected DeprecatedOrder createOrder(String orderId ,String productId,DeprecatedOrderContext context){
        throw new UnsupportedOperationException();
    }
    protected DeprecatedOrder payOrder(String orderId ,DeprecatedOrderContext context){
        throw new UnsupportedOperationException();
    }
    protected DeprecatedOrder sendOrder(String orderId ,DeprecatedOrderContext context){
        throw new UnsupportedOperationException();
    }
    protected DeprecatedOrder receiveOrder(String orderId ,DeprecatedOrderContext context){
        throw new UnsupportedOperationException();
    }

}
