package com.xima.diveinspringboot.annotation;

import com.xima.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//没有弹性，直接定义类
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld_Configuration {
}
