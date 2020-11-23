package com.xima.jvm.practice.stage1_classloader;

/**
 * 当一个接口在初始化时，并不要求其接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时）,才会初始化
 *
 * + 接口中定义的变量默认都是 public final static
 *
 * {}实例化代码块 @see MyTest5_1.java
 *
 * result==================
 * [0.254s][info   ][class,load] com.xima.jvm.practice.stage1_classloader.MyParent5 source: file:/Users/xmly/practice/code/vince-practice/jvm-practice/target/classes/
 * [0.254s][info   ][class,load] com.xima.jvm.practice.stage1_classloader.MyChild5 source: file:/Users/xmly/practice/code/vince-practice/jvm-practice/target/classes/
 * [0.255s][info   ][class,load] com.xima.jvm.practice.stage1_classloader.MyParent5$1 source: file:/Users/xmly/practice/code/vince-practice/jvm-practice/target/classes/
 * 6
 *
 * 只是加载MyParent5，并未初始化MyParent5
 * 如果将MyParent5，则会被初始化，
 * 证明了：
 *  + 在初始化一个类时，并不会初始化它所实现的接口
 *  + 在初始化一个接口时，并不会先初始化它的父接口
 *
 *
 *
 */
public class MyTest5_接口初始化规则 {
    public static void main(String[] args) {
        //在初始化一个类时，并不会初始化它所实现的接口
        System.out.println(MyChild5.b);
        //在初始化一个接口时，并不会先初始化它的父接口
        System.out.println(MyParent5_1.t);
    }
}

interface MyParent5{
    public static Thread t = new Thread(){
        //{}实例化代码块，构造函数之前都会执行
        {
            System.out.println("MyParent5 invoke");
        }
    };
}

class MyChild5 implements MyParent5{
    public static int b = 632;
}

interface MyGrandpa5_1{
    public static Thread t = new Thread(){
        {
            System.out.println("MyGrandpa5_1 invoke");
        }
    };
}

interface MyParent5_1 extends MyGrandpa5_1{
    public static Thread t = new Thread(){
        {
            System.out.println("MyParent5_1 invoke");
        }
    };
}


