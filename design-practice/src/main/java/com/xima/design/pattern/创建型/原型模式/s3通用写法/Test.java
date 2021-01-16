package com.xima.design.pattern.创建型.原型模式.s3通用写法;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setId(1);
        concretePrototype.setUserId(2);
        concretePrototype.setExamStartTime(new Date());
        System.out.println(concretePrototype);

        System.out.println(concretePrototype.clone());
    }
}
