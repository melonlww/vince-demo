package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

public class Test {

    public static void main(String[] args) {
        //模拟用户获取策略选项
        PromotionStrategyFactory.getPromotionKeys();
        //用户选择其中一个
        String promotionKey = "COUPON";
        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);

        PromotionActivity activity = new PromotionActivity(promotionStrategy);
        activity.execute();
    }
}
