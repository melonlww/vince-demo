package com.xima.jvm.practice.stage1_classloader;

/**
 *
 * 如果子类通过.的方式直接调用父类的静态变量或者父类的静态方法，就表示是对父类的主动使用，
 * 而并不是表示对自己子类主动使用，也就是说这个静态变量或者静态方法定义在谁身上就表示对谁的主动使用，
 * 而不看调用方是谁
 *
 * result============================
 Parent11 static block
 3
 -----------
 do Something
 */
public class MyTest11_父类静态变量的主动使用 {
    public static void main(String[] args) {
        System.out.println(Child11.a);
        System.out.println("-----------");
        Child11.doSomething();
    }
}

class Parent11 {
    static int a = 3;

    static {
        System.out.println("Parent11 static block");
    }

    static void doSomething() {
        System.out.println("do Something");
    }
}

class Child11 extends Parent11 {
    static {
        System.out.println("Child11 static block");
    }
}