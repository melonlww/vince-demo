package com.xima.diveinspringboot.configuration;

import com.xima.diveinspringboot.annotation.EnableHelloWorld_ImportSelector;
import com.xima.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld自动装配
 */
@Configuration //spring模式注解
@EnableHelloWorld_ImportSelector //spring @Enable装配
//@ConditionalOnSystemProperty(name = "user.name", value = "xmly") //条件装配
@ConditionalOnSystemProperty(name = "user.name", value = "liweiwei")
public class HelloWorldAutoConfiguration {
}
