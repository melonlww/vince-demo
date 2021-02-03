package com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式;

import com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.payport.AliPay;
import com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.payport.JDPay;
import com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.payport.UnionPay;
import com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.payport.WeChatPay;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    public static final String ALI_PAY = "ALI_PAY";
    public static final String JD_PAY = "JD_PAY";
    public static final String WE_CHAT_PAY = "WE_CHAT_PAY";
    public static final String UNION_PAY = "UNION_PAY";

    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> strategy = new HashMap<>();

    static {
        strategy.put(ALI_PAY, new AliPay());
        strategy.put(JD_PAY, new JDPay());
        strategy.put(WE_CHAT_PAY, new WeChatPay());
        strategy.put(UNION_PAY, new UnionPay());
    }

    private PayStrategy() {
    }

    public static Payment get(String payKey) {
        if (!strategy.containsKey(payKey)) {
            return strategy.get(DEFAULT_PAY);
        }
        return strategy.get(payKey);
    }
}
