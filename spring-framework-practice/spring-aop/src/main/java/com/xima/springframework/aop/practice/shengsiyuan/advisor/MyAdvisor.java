package com.xima.springframework.aop.practice.shengsiyuan.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before MyAdvisor invoke");
        Object obj = invocation.proceed();
        System.out.println("after MyAdvisor invoke");
        return obj;
    }
}
