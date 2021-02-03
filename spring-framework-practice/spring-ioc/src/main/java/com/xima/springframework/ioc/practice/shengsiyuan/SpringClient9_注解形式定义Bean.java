package com.xima.springframework.ioc.practice.shengsiyuan;

import com.xima.springframework.ioc.practice.shengsiyuan.annotation.bean.Person;
import com.xima.springframework.ioc.practice.shengsiyuan.annotation.config.PersonConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解与基于xml配置的Spring Bean在创建时机上存在唯一的不同之处：
 * 1.基于XMl配置的方式，Bean对象的创建是在程序首次从工厂中获取对象时才创建的
 * 2.基于注解配置的方式，Bean对象的创建是在注解处理器解析相应的@Bean注解时调用了该注解所修饰的方法，当
 * 该方法执行后，相应的对象自然就已经被创建出来了，这是，Spring就会将该对象纳入到工厂的管理范围之内，当
 * 我们首次尝试从工厂中获取到该Bean对象，这是，该Bean对象实际上已经完成了创建并已被纳入到了工厂的管理范围
 * 之内
 *
 */
public class SpringClient9_注解形式定义Bean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(PersonConfiguration.class);
        annotationConfigApplicationContext.refresh();

        System.out.println("finish refresh");

        PersonConfiguration personConfiguration = (PersonConfiguration)annotationConfigApplicationContext.getBean("personConfiguration");
        Person person = (Person)annotationConfigApplicationContext.getBean("person_zhangsan");

        System.out.println(personConfiguration.getClass());
        System.out.println(person.getClass());
        System.out.println(person);
    }
}
