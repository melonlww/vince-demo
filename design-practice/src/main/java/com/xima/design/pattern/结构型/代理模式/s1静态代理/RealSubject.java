package com.xima.design.pattern.结构型.代理模式.s1静态代理;

public class RealSubject implements ISubject {

    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
