package com.xima.design.pattern.结构型.代理模式.s2动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private ISubject target;

    public ISubject getInstance(ISubject target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (ISubject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("JdkProxy called before request().");
    }

    private void after() {
        System.out.println("JdkProxy called after request().");
    }
}
