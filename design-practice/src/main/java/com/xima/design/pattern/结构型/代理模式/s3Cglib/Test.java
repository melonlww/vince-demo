package com.xima.design.pattern.结构型.代理模式.s3Cglib;

import com.xima.design.pattern.结构型.代理模式.obj.RealObj;

public class Test {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        RealObj subject = (RealObj)cglibProxy.getInstance(RealObj.class);
        subject.request();
    }
}
