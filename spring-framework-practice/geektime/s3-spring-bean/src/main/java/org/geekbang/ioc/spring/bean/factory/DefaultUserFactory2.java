package org.geekbang.ioc.spring.bean.factory;

import javax.annotation.PostConstruct;

/**
 * 默认 {@link UserFactory} 实现
 *
 */
public class DefaultUserFactory2 implements UserFactory{

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

}
