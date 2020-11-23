package com.xima.jvm.practice.stage2_bytecode;

/**
 *  invokeinterface：调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的哪个对象的特定方法
 *  invokestatic：调用静态方法
 *  invokespecial：调用自己的私有方法、构造方法（<init>）以及父类的方法
 *  invokevirtual：调用虚方法（实例方法），运行期动态查找的过程。
 *  invokedynamic：动态调用方法，java 1.7开始引入
 *
 *  静态解析的4种情形
 *  1.静态方法
 *  2.父类方法
 *  3.构造方法
 *  4.私有方法（无法被重写）
 *  以上4类方法称为非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用的
 *
 *
 *
 *
 *
 *  实验一：invokestatic 操作
 *   操作：
 *   1.进入classpath
 *   2.javap生成字节码  -p打印private的字段和方法
 *   javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest4_字节码invoke操作
 *
 *  其他忽略 主要关注test和main方法
 *   main方法中   0: invokestatic  #5                  // Method test:()V
 *
 *
 *    public static void test();
 *     descriptor: ()V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String test invoked
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 7: 8
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: invokestatic  #5                  // Method test:()V
 *          3: return
 *       LineNumberTable:
 *         line 10: 0
 *         line 11: 3
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       4     0  args   [Ljava/lang/String;
 */
public class MyTest4_invokestatic操作_静态解析 {

    public static void test(){
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
