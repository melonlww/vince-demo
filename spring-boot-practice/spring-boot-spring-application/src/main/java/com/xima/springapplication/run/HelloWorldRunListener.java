package com.xima.springapplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 模拟{@link EventPublishingRunListener}
 *
 * springApplication 通过反射调用，
 * 所以一定要实现带 public HelloWorldRunListener(SpringApplication application, String[] args)的构造方法
 */
public class HelloWorldRunListener implements SpringApplicationRunListener, Ordered {

    public HelloWorldRunListener(SpringApplication application, String[] args){
        System.out.println("invoke");
    }



    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
