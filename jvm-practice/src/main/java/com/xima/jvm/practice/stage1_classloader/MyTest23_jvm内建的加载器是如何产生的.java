package com.xima.jvm.practice.stage1_classloader;

public class MyTest23_jvm内建的加载器是如何产生的 {

    public static void main(String[] args) {
        System.out.println("BootstrapClassloader:" + System.getProperty("sun.boot.class.path"));
        System.out.println("ExtClassloader:" + System.getProperty("java.ext.dirs"));
        System.out.println("AppClassloader:" + System.getProperty("java.class.path"));


        /**
         * 内建于jvm中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类
         * 当jvm启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器
         * 这块特殊的机器码叫做启动类加载器（Bootstrap）
         *
         * 启动类加载器并不是java类，而其他的加载器则是java类，
         * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程
         *
         * 所有类加载器（除了启动类加载器）都被实现为java类，不过，总归要有一个组件来加载第一个java类加载器，从而让整个加载过程能够顺利
         * 进行下去，加载第一个纯java类加载器就是启动类加载器的职责
         *
         * 启动类加载器还会负责加载供jre正常运行所需要的组件，这包括java.util与java.lang包中的类等等
         *
        扩展类加载器与系统类加载器也是由启动类加载器加载的
         */
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println(MyTest23_jvm内建的加载器是如何产生的.class.getClassLoader());

        System.out.println(HelloWorld.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
