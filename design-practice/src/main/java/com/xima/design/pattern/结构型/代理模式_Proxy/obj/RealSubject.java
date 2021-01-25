package com.xima.design.pattern.结构型.代理模式_Proxy.obj;

public class RealSubject implements ISubject {

    @Override
    public void request() {
        System.out.println("real service is called.");
    }

    @Override
    public void showName(String name) {
        System.out.println("real service name is " + name + ".");
    }
}
