package com.xima.jvm.practice.stage1_classloader;

/**
 * 操作步骤
 * 1. 进入classpath目录
 * cd D:\project1\vince-practice\jvm-practice\target
 * 2. 将ext classloader加载目录设置到当前classpath下
 * java -Djava.ext.dirs=./ com.xima.jvm.practice.stage1_classloader.MyTest22

 * result=====================================
 * MyTest22 init
 * jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
 * jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
 *
 *
 *
 * 为啥不是ext classloader去加载?????
 * 原因为ext classloader只加载jar包
 * 那将class文件打成jar包重新来一遍
 * 1. 进入classpath目录
 * cd D:\project1\vince-practice\jvm-practice\target
 * 2。将HelloWorld.class打入jar包
 * jar cvf test.jar com/xima/jvm/practice/stage1_classloader/HelloWorld.class
 * 3.java -Djava.ext.dirs=./ com.xima.jvm.practice.stage1_classloader.MyTest22
 * result=====================================
 * MyTest22 init
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * sun.miscc.Launcher$ExtClassLoader@3d4eac69
 *
 * OK！这次成功了
 * HelloWorld成功被ext classloader加载
 *
 * 如果将MyTest22.class也加到jar包内会怎样呢？
 * jar cvf test2.jar com/xima/jvm/practice/stage1_classloader/MyTest22.class
 * java -Djava.ext.dirs=./ com.xima.jvm.practice.stage1_classloader.MyTest22
 * result=====================================
 * MyTest22 init
 * sun.misc.Launcher$ExtClassLoader@33909752
 * sun.misc.Launcher$ExtClassLoader@33909752
 *
 * 实验证明：也会被ext classloader加载
 */
public class MyTest22_ExtClassloader只加载jar包 {

    static{
        System.out.println("MyTest22 init");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22_ExtClassloader只加载jar包.class.getClassLoader());
        System.out.println(HelloWorld.class.getClassLoader());
    }
}
