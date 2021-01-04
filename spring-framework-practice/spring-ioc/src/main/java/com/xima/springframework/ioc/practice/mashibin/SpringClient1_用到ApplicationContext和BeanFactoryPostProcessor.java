package com.xima.springframework.ioc.practice.mashibin;

import com.xima.springframework.ioc.practice.mashibin.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用到ApplicationContext 会加载到自定义的MyBeanFactoryPostProcessor
 *
 * 需要引入spring-context maven包
 *
 */
public class SpringClient1_用到ApplicationContext和BeanFactoryPostProcessor {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
        Person student = (Person) ctx.getBean("person");
        System.out.println(student);
    }
}
