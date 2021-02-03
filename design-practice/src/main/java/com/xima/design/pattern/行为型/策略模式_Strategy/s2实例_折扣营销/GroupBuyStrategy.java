package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

public class GroupBuyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("团购优惠");
    }
}
