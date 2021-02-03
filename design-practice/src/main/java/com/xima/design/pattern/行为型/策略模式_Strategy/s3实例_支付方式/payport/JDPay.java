package com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.payport;

import com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式.Payment;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    public double queryBalance(String uid) {
        return 900;
    }
}
