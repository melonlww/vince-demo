package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

public class CashBackStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
