package com.xima.design.pattern.结构型.代理模式.s2动态代理;

import com.xima.design.pattern.结构型.代理模式.obj.ISubject;
import com.xima.design.pattern.结构型.代理模式.obj.RealSubject;

public class Test {

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        ISubject subject = (ISubject)jdkProxy.getInstance(new RealSubject());
        subject.request();
    }
}
