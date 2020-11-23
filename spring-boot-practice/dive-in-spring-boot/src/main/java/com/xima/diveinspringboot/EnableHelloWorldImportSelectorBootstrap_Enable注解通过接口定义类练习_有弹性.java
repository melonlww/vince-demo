package com.xima.diveinspringboot;

import com.xima.diveinspringboot.annotation.EnableHelloWorld_ImportSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @EnableHelloWorld_ImportSelector中@Import定义接口, 可以通过ImportSelector接口，自定义实现多种返回值，有弹性
 */
@EnableHelloWorld_ImportSelector
public class EnableHelloWorldImportSelectorBootstrap_Enable注解通过接口定义类练习_有弹性 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldImportSelectorBootstrap_Enable注解通过接口定义类练习_有弹性.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld bean: " + helloWorld);

        context.close();
    }
}
