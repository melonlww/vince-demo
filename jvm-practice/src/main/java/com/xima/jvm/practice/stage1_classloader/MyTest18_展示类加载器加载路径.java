package com.xima.jvm.practice.stage1_classloader;

/**
 * 此系统变量仅限于java8之前
 */
public class MyTest18_展示类加载器加载路径 {

    public static void main(String[] args) {
        System.out.println("BootstrapClassloader:" + System.getProperty("sun.boot.class.path"));
        System.out.println("ExtClassloader:" + System.getProperty("java.ext.dirs"));
        System.out.println("AppClassloader:" + System.getProperty("java.class.path"));


    }

}
