package com.xima.jvm.practice.stage1_classloader;

import java.lang.reflect.InvocationTargetException;

public class MyTest17_复杂类加载 extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyTest16_1_自定义类加载器_双亲委派 loader1 = new MyTest16_1_自定义类加载器_双亲委派("loader1");
//        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        loader1.setPath("D:\\project1\\vince-practice\\jvm-practice\\file\\");
        Class<?> clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.MySample");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("classloader:" + clazz.getClassLoader());

        //如果注释掉该行，那么并不会实例化MySample，即MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat class
//        Object object = clazz.getDeclaredConstructor().newInstance();
    }

}
