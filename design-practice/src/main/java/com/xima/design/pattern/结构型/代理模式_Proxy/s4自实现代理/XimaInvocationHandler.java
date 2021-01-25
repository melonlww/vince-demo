package com.xima.design.pattern.结构型.代理模式_Proxy.s4自实现代理;

import java.lang.reflect.Method;

public interface XimaInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
