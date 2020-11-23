package com.xima.diveinspringboot;

import com.xima.diveinspringboot.annotation.EnableHelloWorld_Configuration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @EnableHelloWorld_Configuration中@Import直接定义类, 只能定义一个类，没有弹性
 *
 */
@EnableHelloWorld_Configuration
public class EnableHelloWorldConfigurationBootstrap_Enable注解直接定义类练习_没有弹性 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldConfigurationBootstrap_Enable注解直接定义类练习_没有弹性.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("helloWorld bean: " + helloWorld);

        context.close();
    }
}
