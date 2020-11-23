package com.xima.jvm.practice.stage1_classloader;

/**
 * 查看Java字节码，下面使用 javap 来稍微看一下字节码到底长什么样子？
 *  ***************执行步骤***************
 * 1 进入工程目录
 * 2.cd src/main/java
 * 3.javac com/xima/jvm/practice/stage1_classloader/HelloWorld.java
 * 4.java com.xima.jvm.practice.stage1_classloader.HelloWorld  代码可以成功执行
 * 5.javap -c com.xima.jvm.practice.stage1_classloader.HelloWorld
 *
 *
 *  ***************输出结果***************
 * Compiled from "HelloWorld.java"
 * public class com.xima.jvm.practice.stage1_classloader.HelloWorld {
 *   public com.xima.jvm.practice.stage1_classloader.HelloWorld();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #3                  // String hello world
 *        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
