package com.xima.jvm.practice.stage1_classloader;

/**
 * result===========================
 *
 * class [Ljava.lang.String;
 * null
 * null
 * ------------------
 * class [Lcom.xima.jvm.practice.stage1_classloader.Array_Simple;
 * jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 * jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 * ------------------
 * class [I
 * null
 * null
 *
 *
 */
public class MyTest15_数组的类加载器 {
    public static void main(String[] args) {
        /**
         * 这里的null表示Bootstrap class loader
         */
        String[] strings = new String[1];
        System.out.println(strings.getClass());
        System.out.println(String.class.getClassLoader());
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("------------------");
        Array_Simple[] arrays = new Array_Simple[1];
        System.out.println(arrays.getClass());
        System.out.println(Array_Simple.class.getClassLoader());
        System.out.println(arrays.getClass().getClassLoader());
        System.out.println("------------------");
        /**
         * 这里的null表示没有classloader
         * 来自ClassLoader class doc
         * if the element type is a primitive type, then the array class has no
         * class loader.
         */
        int[] ints = new int[2];
        System.out.println(ints.getClass());
        System.out.println(int.class.getClassLoader());
        System.out.println(ints.getClass().getClassLoader());
    }
}

class Array_Simple{

}
