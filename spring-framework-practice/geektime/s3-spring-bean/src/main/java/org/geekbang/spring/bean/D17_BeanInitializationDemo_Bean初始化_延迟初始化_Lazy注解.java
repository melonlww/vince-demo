package org.geekbang.spring.bean;

import org.geekbang.spring.bean.factory.DefaultUserFactory5;
import org.geekbang.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化 Demo
 *
 * 非Lazy Bean 在applicationContext上下文启动前已经初始化
 *
 * 打印：
 * @PostConstruct : UserFactory 初始化中...
 * InitializingBean#afterPropertiesSet() : UserFactory 初始化中...
 * 自定义初始化方法 initUserFactory() : UserFactory 初始化中...
 * ===================Spring 应用上下文已启动===================
 * org.geekbang.ioc.spring.bean.factory.DefaultUserFactory5@3c73951
 *
 *
 *
 * @Lazy
 * Lazy Bean 在applicationContext上下文启动后 applicationContext.getBean方法调用的时候才会被初始化
 *
 * 打印：
 * ===================Spring 应用上下文已启动===================
 * @PostConstruct : UserFactory 初始化中...
 * InitializingBean#afterPropertiesSet() : UserFactory 初始化中...
 * 自定义初始化方法 initUserFactory() : UserFactory 初始化中...
 * org.geekbang.ioc.spring.bean.factory.DefaultUserFactory5@76c3e77a
 *
 *
 *
 *
 */
@Configuration // Configuration Class
public class D17_BeanInitializationDemo_Bean初始化_延迟初始化_Lazy注解 {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(D17_BeanInitializationDemo_Bean初始化_延迟初始化_Lazy注解.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("===================Spring 应用上下文已启动===================");
        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
//    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory5();
    }
}
