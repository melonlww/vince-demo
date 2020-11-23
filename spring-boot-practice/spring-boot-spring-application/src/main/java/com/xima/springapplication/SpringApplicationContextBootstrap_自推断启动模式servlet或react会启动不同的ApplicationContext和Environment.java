package com.xima.springapplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ########## SpringApplication 准备阶段 ##############
 * spring应用上下文引导类
 *
 * 自推断启动模式servlet或react会启动不同的ApplicationContext和Environment
 *
 * 自推断启动模式
 * 1.根据WebApplicationType#deduceFromClasspath方法推断
 * 2 或者显示指定SpringApplicationBuilder.web(WebApplicationType.NONE)
 *
 * 推断启动类（main）
 * SpringApplication#deduceMainApplicationClass方法中
 * 推断规则：通过获取当前线程的异常堆栈,获得方法名称为main的方法，即为启动类
 *
 * 加载Initializer
 * SpringApplication#getSpringFactoriesInstances 方法
 * 通过SpringFactoriesLoader实现加载Initializer类，然后进行排序
 *
 *
 * ########## SpringApplication 启动阶段 ##############
 * run方法中
 * SpringApplicationRunListeners listeners = getRunListeners(args);
 * return new SpringApplicationRunListeners(logger,
 * 				getSpringFactoriesInstances(SpringApplicationRunListener.class, types, this, args));
 * SpringApplication#getRunListeners 准备好接下去需要获得构造函数的参数  Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
 * SpringApplication#createSpringFactoriesInstances通过反射调用
 * 所以一定要实现带 public HelloWorldRunListener(SpringApplication application, String[] args)的构造方法
 *
 *
 *
 *
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap_自推断启动模式servlet或react会启动不同的ApplicationContext和Environment {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap_自推断启动模式servlet或react会启动不同的ApplicationContext和Environment.class)
//                .web(WebApplicationType.NONE)
                .run(args);
        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());
        context.close();
    }
}
