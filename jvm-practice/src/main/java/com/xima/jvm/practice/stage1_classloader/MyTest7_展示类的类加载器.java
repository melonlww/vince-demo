package com.xima.jvm.practice.stage1_classloader;


/**
 * result===================
 * null
 * jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 *
 *
 *
 *
 */
public class MyTest7_展示类的类加载器 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        /**
         * getClassLoader方法的注解：
         * * Returns the class loader for the class.  Some implementations may use
         *      * null to represent the bootstrap class loader.
         *
         *  某些实现用null代表bootstrap classloader
         */
        System.out.println(clazz.getClassLoader());


        Class<?> clazz2 = Class.forName("com.xima.jvm.practice.stage1_classloader.Sample");
        System.out.println(clazz2.getClassLoader()  );
    }
}

class Sample{

}