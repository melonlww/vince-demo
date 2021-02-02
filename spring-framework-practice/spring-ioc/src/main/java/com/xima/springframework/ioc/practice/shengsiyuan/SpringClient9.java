package com.xima.springframework.ioc.practice.shengsiyuan;

import com.xima.springframework.ioc.practice.shengsiyuan.annotation.bean.Person;
import com.xima.springframework.ioc.practice.shengsiyuan.annotation.config.PersonConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringClient9 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(PersonConfiguration.class);
        annotationConfigApplicationContext.refresh();

        Person person = (Person)annotationConfigApplicationContext.getBean("person_zhangsan");
        System.out.println(person);
    }
}
