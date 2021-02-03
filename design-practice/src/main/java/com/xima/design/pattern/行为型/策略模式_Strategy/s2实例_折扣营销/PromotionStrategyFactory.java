package com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销;

import com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.strategy.CashBackStrategy;
import com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.strategy.CouponStrategy;
import com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.strategy.EmptyStrategy;
import com.xima.design.pattern.行为型.策略模式_Strategy.s2实例_折扣营销.strategy.GroupBuyStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PromotionStrategyFactory {

    private static Map<String, IPromotionStrategy> PROMOTIONS = new HashMap<>();

    static {
        PROMOTIONS.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASH_BACK, new CashBackStrategy());
        PROMOTIONS.put(PromotionKey.GROUP_BUY, new GroupBuyStrategy());
    }

    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    private PromotionStrategyFactory() {
    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASH_BACK = "CASH_BACK";
        String GROUP_BUY = "GROUP_BUY";
    }

    public static Set<String> getPromotionKeys() {
        return PROMOTIONS.keySet();
    }
}
