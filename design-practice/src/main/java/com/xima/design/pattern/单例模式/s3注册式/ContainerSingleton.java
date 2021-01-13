package com.xima.design.pattern.单例模式.s3注册式;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        if (ioc.containsKey(className)) {
            return ioc.get(className);
        }
        Object instance = null;
        //保证线程安全， 参考spring getBean中代码，类似双重检查
        synchronized (ContainerSingleton.class) {
            if (ioc.containsKey(className)) {
                return ioc.get(className);
            }
            try {
                instance = Class.forName(className).getDeclaredConstructor().newInstance();
                ioc.put(className, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
