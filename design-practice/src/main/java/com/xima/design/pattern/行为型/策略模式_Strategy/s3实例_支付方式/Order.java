package com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式;

public class Order {

    private String uid;
    private String orderNo;
    private double amount;

    public Order(String uid, String orderNo, double amount) {
        this.uid = uid;
        this.orderNo = orderNo;
        this.amount = amount;
    }

    public MsgResult pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本此交易金额为" + amount + "，开始扣款");
        return payment.pay(uid, amount);
    }
}
