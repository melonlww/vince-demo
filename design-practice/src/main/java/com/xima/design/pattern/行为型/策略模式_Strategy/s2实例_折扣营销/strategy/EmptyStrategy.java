package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.strategy;

import com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.IPromotionStrategy;

public class EmptyStrategy implements IPromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
