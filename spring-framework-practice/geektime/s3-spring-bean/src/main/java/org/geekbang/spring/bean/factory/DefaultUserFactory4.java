package org.geekbang.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

/**
 * 默认 {@link UserFactory} 实现
 *
 */
public class DefaultUserFactory4 implements UserFactory, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory 初始化中...");
    }
}
