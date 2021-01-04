package com.xima.springframework.ioc.practice;

import com.xima.springframework.ioc.practice.mashibin.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class SpringClient2 {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean.getBeanName());
        System.out.println(bean.getEnvironment());
    }
}
