package com.xima.design.pattern.结构型.代理模式.s3Cglib;

public class Test {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        RealSubject subject = (RealSubject)cglibProxy.getInstance(RealSubject.class);
        subject.request();
    }
}
