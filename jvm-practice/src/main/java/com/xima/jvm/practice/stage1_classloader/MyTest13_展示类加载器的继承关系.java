package com.xima.jvm.practice.stage1_classloader;

public class MyTest13_展示类加载器的继承关系 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while(classLoader!=null){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
