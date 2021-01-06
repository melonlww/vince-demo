package com.xima.springframework.ioc.practice.mashibin;

import com.xima.springframework.ioc.practice.mashibin.bean.PersonA;
import com.xima.springframework.ioc.practice.mashibin.bean.PersonB;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class SpringClient3_循环依赖 {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
        PersonA personA = ctx.getBean(PersonA.class);
        PersonB personB = ctx.getBean(PersonB.class);
        System.out.println(personA);
        System.out.println(personB);
    }
}
