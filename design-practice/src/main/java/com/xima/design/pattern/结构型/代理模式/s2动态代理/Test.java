package com.xima.design.pattern.结构型.代理模式.s2动态代理;

public class Test {

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        ISubject subject = jdkProxy.getInstance(new RealSubject());
        subject.request();
    }
}
