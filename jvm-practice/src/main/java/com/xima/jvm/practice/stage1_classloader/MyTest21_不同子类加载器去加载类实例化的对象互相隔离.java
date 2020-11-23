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
 * invoke MyPerson static
 * invoke MyPerson static
 * Exception in thread "main" java.lang.reflect.InvocationTargetException
 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
 * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
 * 	at com.xima.jvm.practice.stage1_classloader.MyTest20_1_不同子类加载器去加载类.main(MyTest20_1_不同子类加载器去加载类.java:37)
 * Caused by: java.lang.ClassCastException: class com.xima.jvm.practice.stage1_classloader.MyPerson cannot be cast to class com.xima.jvm.practice.stage1_classloader.MyPerson (com.xima.jvm.practice.stage1_classloader.MyPerson is in unnamed module of loader com.xima.jvm.practice.stage1_classloader.MyTest16_1_自定义类加载器_双亲委派 @52af6cff; com.xima.jvm.practice.stage1_classloader.MyPerson is in unnamed module of loader com.xima.jvm.practice.stage1_classloader.MyTest16_1_自定义类加载器_双亲委派 @531be3c5)
 * 	at com.xima.jvm.practice.stage1_classloader.MyPerson.setMyPersonObject(MyPerson.java:11)
 * 	... 5 more
 *
 *
 *
 * 由于loader1加载出来的MyPerson对象无法看到loader2加载出来的MyPerson对象,
 * 当setMyPersonObject方法中发生(MyPerson) myPerson类型强转时,无法识别,报了ClassCastException异常!!
 * 	Method method1 = clazz1.getMethod("setMyPersonObject", Object.class);
 * 	method1.invoke(object1, object2);
 *
 *
 */
public class MyTest21_不同子类加载器去加载类实例化的对象互相隔离 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyTest16_1_自定义类加载器_双亲委派 loader1 = new MyTest16_1_自定义类加载器_双亲委派("loader1");
//        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        loader1.setPath("D:\\project1\\vince-practice\\jvm-practice\\file\\");
        MyTest16_1_自定义类加载器_双亲委派 loader2 = new MyTest16_1_自定义类加载器_双亲委派("loader2");
//        loader2.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        loader2.setPath("D:\\project1\\vince-practice\\jvm-practice\\file\\");

        Class<?> clazz1 = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.MyPerson");
        System.out.println("clazz1 classloader:" + clazz1.getClassLoader());
        Class<?> clazz2 = loader2.loadClass("com.xima.jvm.practice.stage1_classloader.MyPerson");
        System.out.println("clazz2 classloader:" + clazz2.getClassLoader());
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.getDeclaredConstructor().newInstance();
        Object object2 = clazz2.getDeclaredConstructor().newInstance();
        Method method1 = clazz1.getMethod("setMyPersonObject", Object.class);
        method1.invoke(object1, object2);
    }
}
