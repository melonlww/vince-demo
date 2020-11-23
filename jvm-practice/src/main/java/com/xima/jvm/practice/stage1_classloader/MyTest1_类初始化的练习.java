package com.xima.jvm.practice.stage1_classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会初始化
 * 当一个类初始化时，要求其父类全部都已经初始化了
 *
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印
 * =================result===============
 * [0.003s][warning][arguments] -XX:+TraceClassLoading is deprecated. Will use -Xlog:class+load=info instead.
 * [0.009s][info   ][class,load] opened: /Library/Java/JavaVirtualMachines/jdk-11.0.4.jdk/Contents/Home/lib/modules
 * [0.017s][info   ][class,load] java.lang.Object source: jrt:/java.base
 * [0.017s][info   ][class,load] java.io.Serializable source: jrt:/java.base
 * [0.017s][info   ][class,load] java.lang.Comparable source: jrt:/java.base
 * ......
 * [0.220s][info   ][class,load] java.lang.Shutdown source: jrt:/java.base
 * [0.220s][info   ][class,load] jdk.net.ExtendedSocketOptions$PlatformSocketOptions$1 source: jrt:/jdk.net
 * [0.220s][info   ][class,load] java.lang.Shutdown$Lock source: jrt:/java.base
 * [0.220s][info   ][class,load] jdk.net.MacOSXSocketOptions source: jrt:/jdk.net
 * [0.220s][info   ][class,load] jdk.net.MacOSXSocketOptions$$Lambda$14/0x0000000800066840 source: jdk.net.MacOSXSocketOptions
 *
 * 设置虚拟机参数的三种方式：
 * -XX:+<option>,表示开启option选项
 * -XX:-<option>,表示关闭option选项
 * -XX:<option>=<value>，表示将option选项值设置为value
 *
 */


public class MyTest1_类初始化的练习 {
    public static void main(String[] args) {
        //test1
        System.out.println(MyChild1.str);
        //test2
        MyParent1 test = new MyChild1();
        test.output();


    }
}

class MyParent1{
    public static String str = "hello world";
    static{
        System.out.println("MyParent1 static block");
    }
    public static void output(){
        System.out.println("parent invoke");
    }
}

class MyChild1 extends MyParent1{
    static{
        System.out.println("MyChild1 static block");
    }
    public static void output(){
        System.out.println("child invoke");
    }
}