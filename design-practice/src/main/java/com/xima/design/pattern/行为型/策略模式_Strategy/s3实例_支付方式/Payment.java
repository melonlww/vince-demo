package com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式;

public abstract class Payment {

    public abstract String getName();

    public abstract double queryBalance(String uid);

    //通用逻辑放到抽象类里面实现
    public MsgResult pay(String uid, double amount) {
        //余额是否足够
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(200, "支付成功", "支付金额" + amount);
    }
}
