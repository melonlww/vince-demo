package com.xima.diveinspringboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//有弹性，可以通过接口，自定义实现多种返回值
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld_ImportSelector {
}
