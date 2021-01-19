package com.xima.design.pattern.结构型.代理模式.s1静态代理;

import com.xima.design.pattern.结构型.代理模式.obj.ISubject;
import com.xima.design.pattern.结构型.代理模式.obj.RealSubject;

public class Test {

    public static void main(String[] args) {
        ISubject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
