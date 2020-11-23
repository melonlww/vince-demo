package com.xima.jvm.practice.stage1_classloader;

/**
 * result==============
 * MyTest9 static block
 * Parent9 static block
 * Child9 static block
 * 4
 *
 */
public class MyTest9_类初始化的练习 {
    static{
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child9.b);
    }
}

class Parent9{
    static int a = 3;
    static{
        System.out.println("Parent9 static block");
    }
}

class Child9 extends Parent9{
    static int b = 4;
    static{
        System.out.println("Child9 static block");
    }
}

