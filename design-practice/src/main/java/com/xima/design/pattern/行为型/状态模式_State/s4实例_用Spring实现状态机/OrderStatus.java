package com.xima.design.pattern.行为型.状态模式_State.s4实例_用Spring实现状态机;

/**
 * 订单状态
 */
public enum OrderStatus {
    //待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH
}
