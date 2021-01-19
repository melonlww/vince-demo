package com.xima.design.pattern.结构型.代理模式.s1静态代理;

public class Test {

    public static void main(String[] args) {
        ISubject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
