package com.xima.springframework.aop.practice.shengsiyuan.service.impl;

import com.xima.springframework.aop.practice.shengsiyuan.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void myMethod() {
        System.out.println("myMethod invoked");
    }

    @Override
    public void myMethod2() {
        System.out.println("myMethod invoked222");
    }
}
