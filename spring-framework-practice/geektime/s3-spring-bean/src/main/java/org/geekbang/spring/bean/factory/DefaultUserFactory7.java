package org.geekbang.spring.bean.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认 {@link UserFactory} 实现
 */
public class DefaultUserFactory7 implements UserFactory{

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy : UserFactory 销毁中...");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收...");
    }
}
