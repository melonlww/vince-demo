package com.xima.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringApplication准备阶段
 * spring.factories 中模拟加载应用上下文初始器（ApplicationContextInitializer） 和 加载应用事件监听器（ApplicationListener）的实现
 * 模拟spring boot 工厂加载机制
 *
 * spring.factories:
 *
 * # Initializers实现配置
 * org.springframework.context.ApplicationContextInitializer=\
 * com.xima.springapplication.context.AfterHelloWorldApplicationContextInitializer,\
 * com.xima.springapplication.context.HelloWorldApplicationContextInitializer,\
 * com.xima.springapplication.context.AnnotationConfigServletWebServerApplicationContextInitializer
 *
 * # ApplicationListener实现配置
 * org.springframework.context.ApplicationListener=\
 * com.xima.springapplication.listener.HelloWorldApplicationListener,\
 * com.xima.springapplication.listener.AfterHelloWorldApplicationListener,\
 * com.xima.springapplication.listener.ApplicationReadyEventListener
 *
 * # SpringApplicationRunListener实现配置
 * org.springframework.boot.SpringApplicationRunListener=\
 *
 *
 *
 *
 */
@SpringBootApplication
public class SpringApplicationBootstrap_SpringApplication准备阶段_工厂加载机制 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationBootstrap_SpringApplication准备阶段_工厂加载机制.class, args);
        System.out.println(context.getBean(SpringApplicationBootstrap_SpringApplication准备阶段_工厂加载机制.class));

        System.out.println(Thread.currentThread().getStackTrace());
    }

}
