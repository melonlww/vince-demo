package com.xima.design.pattern.结构型.代理模式.obj;

public class RealSubject implements ISubject {

    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
