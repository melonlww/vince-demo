package com.xima.design.pattern.单例模式.s2懒汉模式;

/**
 * LazyStaticInnerClassSingleton.class
 * LazyStaticInnerClassSingleton$LazyHolder.class
 *
 * 优点：写法优雅，利用了java本身语法特性，性能高，避免了内存浪费
 */
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton() {
        //防止通过反射的方式调用构造方法
        if(LazyHolder.instance!=null){
            throw new RuntimeException("不允许非法访问");
        }
    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton instance = new LazyStaticInnerClassSingleton();
    }
}
