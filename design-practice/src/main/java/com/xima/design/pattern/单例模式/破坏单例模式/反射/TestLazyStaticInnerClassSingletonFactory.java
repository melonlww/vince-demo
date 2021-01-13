package com.xima.design.pattern.单例模式.破坏单例模式.反射;

import com.xima.design.pattern.单例模式.s2懒汉模式.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLazyStaticInnerClassSingletonFactory {

    public static void main(String[] args) {
        try {
            Class<LazyStaticInnerClassSingleton> clazz = LazyStaticInnerClassSingleton.class;
            Constructor<LazyStaticInnerClassSingleton> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            LazyStaticInnerClassSingleton instance1 = constructor.newInstance();
            System.out.println(instance1);
            LazyStaticInnerClassSingleton instance2 = constructor.newInstance();
            System.out.println(instance2);

            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
