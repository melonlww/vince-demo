package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

public class PromotionActivity {
    private IPromotionStrategy promotionStrategy;

    public PromotionActivity(IPromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}
