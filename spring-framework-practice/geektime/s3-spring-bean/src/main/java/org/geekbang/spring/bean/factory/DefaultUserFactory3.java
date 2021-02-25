package org.geekbang.spring.bean.factory;

/**
 * 默认 {@link UserFactory} 实现
 *
 */
public class DefaultUserFactory3 implements UserFactory{

    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory() : UserFactory 初始化中...");
    }

}
