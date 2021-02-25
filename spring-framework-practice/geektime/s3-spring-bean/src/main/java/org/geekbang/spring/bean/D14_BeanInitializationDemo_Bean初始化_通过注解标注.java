package org.geekbang.spring.bean;

import org.geekbang.spring.bean.factory.DefaultUserFactory3;
import org.geekbang.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化 Demo
 *
 */
@Configuration // Configuration Class
public class D14_BeanInitializationDemo_Bean初始化_通过注解标注 {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(D14_BeanInitializationDemo_Bean初始化_通过注解标注.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory() {
        return new DefaultUserFactory3();
    }
}
