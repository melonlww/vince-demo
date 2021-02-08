package com.xima.design.pattern.行为型.状态模式_State.s4实例_订单_Spring状态机;

/**
 * 订单状态改变事件
 */
public enum OrderStatusChangeEvent {
    //支付，收货，确认收款
    PAYED, DELIVERY, RECEIVED
}
