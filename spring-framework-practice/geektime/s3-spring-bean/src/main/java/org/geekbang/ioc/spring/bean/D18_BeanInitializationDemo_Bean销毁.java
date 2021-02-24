package org.geekbang.ioc.spring.bean;

import org.geekbang.ioc.spring.bean.factory.DefaultUserFactory6;
import org.geekbang.ioc.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 销毁 Demo
 *
 * applicationContext.close()方法触发bean销毁方法
 *
 *
 */
@Configuration // Configuration Class
public class D18_BeanInitializationDemo_Bean销毁 {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(D18_BeanInitializationDemo_Bean销毁.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("===================Spring 应用上下文已启动===================");
        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        // 关闭 Spring 应用上下文
        System.out.println("===================Spring 应用上下文准备关闭===================");
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("===================Spring 应用上下文已关闭===================");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    public UserFactory userFactory() {
        return new DefaultUserFactory6();
    }
}
