package com.xima.design.pattern.结构型.代理模式_Proxy.s4自实现代理;

import com.xima.design.pattern.结构型.代理模式_Proxy.obj.ISubject;
import com.xima.design.pattern.结构型.代理模式_Proxy.obj.RealSubject;

public class Test {

    public static void main(String[] args) {
        XimaAgent ximaAgent = new XimaAgent();
        ISubject subject = (ISubject) ximaAgent.getInstance(new RealSubject());
        subject.request();
        subject.showName("ww");
    }
}
