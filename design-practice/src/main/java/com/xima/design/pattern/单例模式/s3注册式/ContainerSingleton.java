package com.xima.design.pattern.单例模式.s3注册式;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        Object instance = null;
        if (ioc.containsKey(className)) {
            instance = ioc.get(className);
        } else {
            try {
                instance = Class.forName(className).getDeclaredConstructor().newInstance();
                ioc.put(className, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        }
        return instance;
    }
}
