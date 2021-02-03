package com.xima.design.pattern.行为型.策略模式_Strategy.s3实例_支付方式;

public class Test {

    public static void main(String[] args) {
        Order order = new Order("1","202102031103133001",324);
        System.out.println(order.pay());

        System.out.println(order.pay(PayStrategy.UNION_PAY));
    }
}
