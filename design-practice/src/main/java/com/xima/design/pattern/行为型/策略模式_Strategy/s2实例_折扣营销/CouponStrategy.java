package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

public class CouponStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("使用优惠券抵扣");
    }
}
