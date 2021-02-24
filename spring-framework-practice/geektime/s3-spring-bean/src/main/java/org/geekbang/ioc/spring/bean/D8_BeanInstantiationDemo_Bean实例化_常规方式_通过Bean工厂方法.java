package org.geekbang.ioc.spring.bean;

import org.geekbang.ioc.overview.domain.User2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化示例
 *
 */
public class D8_BeanInstantiationDemo_Bean实例化_常规方式_通过Bean工厂方法 {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context2.xml");
        User2 user = beanFactory.getBean("user-by-static-method", User2.class);
        User2 userByInstanceMethod  = beanFactory.getBean("user-by-instance-method", User2.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(user == userByInstanceMethod);

    }
}
