package com.xima.design.pattern.结构型.代理模式.s4自实现代理;

import java.lang.reflect.Method;

public class XimaMeipo implements XimaInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return XimaProxy.newProxyInstance(new XimaClassloader(), clazz.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("XimaMeipo called before request().");
    }

    private void after() {
        System.out.println("XimaMeipo called after request().");
    }
}
