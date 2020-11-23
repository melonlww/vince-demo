package com.xima.diveinspringboot;

import com.xima.diveinspringboot.condition.ConditionalOnSystemProperty;
import com.xima.diveinspringboot.condition.OnSystemPropertyCondition;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;

/**
 * 系统属性引导类
 *
 * 通过注解@ConditionalOnSystemProperty中@Conditional(OnSystemPropertyCondition.class)，
 * {@link OnSystemPropertyCondition}实现{@link Condition}的matches方法来判断是否加载bean
 *
 */
public class ConditionOnSystemPropertyBootstrap_Condition注解练习 {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "xmly")
    public String helloWorld() {
        return "hello world vince";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionOnSystemPropertyBootstrap_Condition注解练习.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld bean: " + helloWorld);
        context.close();
    }
}
