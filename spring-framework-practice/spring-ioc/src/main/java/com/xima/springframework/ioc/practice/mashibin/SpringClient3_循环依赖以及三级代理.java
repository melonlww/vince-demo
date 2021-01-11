package com.xima.springframework.ioc.practice.mashibin;

import com.xima.springframework.ioc.practice.mashibin.bean.PersonA;
import com.xima.springframework.ioc.practice.mashibin.bean.PersonB;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean三级缓存.jpg
 *
 * 1.一级缓存放成品对象
 * 2.二级缓存放半成品对象
 * 3.三级缓存放lambda表达式，来完成代理对象的覆盖过程
 */
public class SpringClient3_循环依赖以及三级代理 {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
        PersonA personA = ctx.getBean(PersonA.class);
        PersonB personB = ctx.getBean(PersonB.class);
        System.out.println(personA);
        System.out.println(personB);
    }
}
