package com.xima.jvm.practice.stage1_classloader;

/**
 * classLoader.loadClass不会导致类的初始化
 *
 * Class.forName（反射），导致类初始化， 七种主动使用情况之一
 *
 * 总结：
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 *
 */
class Cl_Sample{
    static{
        System.out.println("Class Cl_Sample");
    }
}

public class MyTest12_loadClass与ClassForName的区别 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.xima.jvm.practice.stage1_classloader.Cl_Sample");
        System.out.println(clazz);
        System.out.println("----------------");
        clazz = Class.forName("com.xima.jvm.practice.stage1_classloader.Cl_Sample");
        System.out.println(clazz);
    }
}


