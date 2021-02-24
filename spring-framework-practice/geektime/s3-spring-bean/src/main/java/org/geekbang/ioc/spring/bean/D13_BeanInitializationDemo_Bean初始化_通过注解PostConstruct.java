package org.geekbang.ioc.spring.bean;

import org.geekbang.ioc.spring.bean.factory.DefaultUserFactory2;
import org.geekbang.ioc.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化 Demo
 *
 */
@Configuration // Configuration Class
public class D13_BeanInitializationDemo_Bean初始化_通过注解PostConstruct {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(D13_BeanInitializationDemo_Bean初始化_通过注解PostConstruct.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean
    public UserFactory userFactory() {
        return new DefaultUserFactory2();
    }
}
