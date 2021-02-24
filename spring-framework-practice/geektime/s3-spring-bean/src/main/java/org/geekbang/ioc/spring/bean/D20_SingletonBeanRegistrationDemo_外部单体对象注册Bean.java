package org.geekbang.ioc.spring.bean;

import org.geekbang.ioc.spring.bean.factory.DefaultUserFactory;
import org.geekbang.ioc.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册实例
 *
 */
public class D20_SingletonBeanRegistrationDemo_外部单体对象注册Bean {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();

        // 创建一个外部 UserFactory 对象
        UserFactory userFactory = new DefaultUserFactory();

        // 注册外部单例对象
        singletonBeanRegistry.registerSingleton("singletonBeanUserFactory", userFactory);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 UserFactory
        UserFactory userFactoryByLookup = applicationContext.getBean("singletonBeanUserFactory", UserFactory.class);
        System.out.println("userFactory  == userFactoryByLookup : " + (userFactory == userFactoryByLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();

    }
}
