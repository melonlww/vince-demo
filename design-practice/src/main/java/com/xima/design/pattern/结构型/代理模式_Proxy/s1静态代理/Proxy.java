package com.xima.design.pattern.结构型.代理模式_Proxy.s1静态代理;

import com.xima.design.pattern.结构型.代理模式_Proxy.obj.ISubject;

public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    @Override
    public void showName(String name) {
        before();
        subject.showName(name);
        after();
    }

    private void before(){
        System.out.println("called before request().");
    }

    private void after(){
        System.out.println("called after request().");
    }
}
