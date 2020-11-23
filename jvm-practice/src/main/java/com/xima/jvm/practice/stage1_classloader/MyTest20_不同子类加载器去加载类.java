package com.xima.jvm.practice.stage1_classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实验1.操作步骤
 * 1. mvn clean compile
 * 2. cp -r target/classes/* file/
 * 3. rm target/classes/com/xima/jvm/practice/stage1_classloader/MyPerson.class
 * 4. run main
 * <p>
 * <p>
 * result ===========================
 * clazz1 classloader:MyTest16_1_自定义类加载器{classLoaderName='loader1'}
 * clazz2 classloader:MyTest16_1_自定义类加载器{classLoaderName='loader2'}
 * false
 */
public class MyTest20_不同子类加载器去加载类 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16_1_自定义类加载器_双亲委派 loader1 = new MyTest16_1_自定义类加载器_双亲委派("loader1");
        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        MyTest16_1_自定义类加载器_双亲委派 loader2 = new MyTest16_1_自定义类加载器_双亲委派("loader2");
        loader2.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");

        Class<?> clazz1 = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.MyPerson");
        System.out.println("clazz1 classloader:" + clazz1.getClassLoader());
        Class<?> clazz2 = loader2.loadClass("com.xima.jvm.practice.stage1_classloader.MyPerson");
        System.out.println("clazz2 classloader:" + clazz2.getClassLoader());
        System.out.println(clazz1 == clazz2);
    }
}
