package com.xima.design.pattern.创建型.原型模式.s2BeanUtils;

import java.lang.reflect.Field;

public class BeanUtils {

    public static Object copy(Object source){
        Class clazz = source.getClass();
        Object prototype = null;
        try{
            prototype = clazz.getDeclaredConstructor().newInstance();
            for(Field field:clazz.getDeclaredFields()){
                field.setAccessible(true);
                field.set(prototype, field.get(source));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
