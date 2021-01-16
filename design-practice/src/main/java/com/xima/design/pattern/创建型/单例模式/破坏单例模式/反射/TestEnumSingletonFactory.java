package com.xima.design.pattern.创建型.单例模式.破坏单例模式.反射;

import com.xima.design.pattern.创建型.单例模式.s3注册式.EnumSingleton;

import java.lang.reflect.Constructor;

/**
 * enum无法被反射调用到构造方法
 *
 * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
 *
 */
public class TestEnumSingletonFactory {

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        System.out.println(instance.getData());

        try {
            Class<EnumSingleton> clazz = EnumSingleton.class;
            Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            EnumSingleton instance1 = constructor.newInstance();
            System.out.println(instance1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
