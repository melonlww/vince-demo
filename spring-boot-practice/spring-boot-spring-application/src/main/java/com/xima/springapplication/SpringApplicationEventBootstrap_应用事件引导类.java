package com.xima.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationEventBootstrap_应用事件引导类 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });
        context.refresh();
        context.publishEvent("自定义事件");
        context.publishEvent("2020 ");
        context.publishEvent(new ApplicationEvent("HelloWorld"){
        });
        context.close();
    }
}
