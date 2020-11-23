package com.xima.jvm.practice.stage1_classloader;

/**
 * run
 * ===========result==============
 * hello world
 *
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中。
 * 本质上，调用类并没有直接引用到定义常量的类，因此，并不会触发定义常量的类的初始化
 *
 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2没有任何关系了
 * 甚至，我们可以将MyParent2的class文件删除
 *
 *
 * javap -c com.xima.jvm.practice.stage1_classloader.MyTest2
 * ===========result==============
 * Compiled from "MyTest2.java"
 * public class com.xima.jvm.practice.stage1_classloader.MyTest2 {
 *   public com.xima.jvm.practice.stage1_classloader.MyTest2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #4                  // String hello world
 *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 * 助记符：ldc
 * 表示将int，float或者String类型的常量值从常量池中推送至栈顶
 *
 * 若访问short/int s = 7
 * 助记符：bipush
 * 表示将单字节（-128 - 127）的常量值推送至栈顶
 *
 * 若访问int i = 128
 * 助记符：sipush
 * 表示将一个短整型常量值（-32768 - 32767）推送至栈顶
 *
 * 若访问int m = 1
 * 助记符：iconst_1
 * 表示将int型的1推送至栈顶（iconst_m1 - iconst_5）[-1,5]
 *
 */
public class MyTest2_类常量初始化 {
    public static void main(String[] args) {
//        System.out.println(MyParent2.s);
//        System.out.println(MyParent2.m2);
        System.out.println(MyParent2.i);
//        System.out.println(MyParent2.m);
//        System.out.println(MyParent2.str);
    }

}

class MyParent2{
    public static final String str = "hello world";
    public static final short s = 7;
    public static final int i = 128;
    public static final int m = 1;
    public static final MyCat m2 = new MyCat();
    public static final MySample mySample =  new MySample();
    static{
        System.out.println("MyParent2 static block");
    }
}