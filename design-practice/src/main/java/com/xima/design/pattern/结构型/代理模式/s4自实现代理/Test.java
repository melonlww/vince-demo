package com.xima.design.pattern.结构型.代理模式.s4自实现代理;

import com.xima.design.pattern.结构型.代理模式.obj.ISubject;
import com.xima.design.pattern.结构型.代理模式.obj.RealSubject;
import com.xima.design.pattern.结构型.代理模式.s2动态代理.JdkProxy;

public class Test {

    public static void main(String[] args) {
        XimaMeipo ximaMeipo = new XimaMeipo();
        ISubject subject = (ISubject)ximaMeipo.getInstance(new RealSubject());
        subject.request();
    }
}
