package com.xima.jvm.practice.stage1_classloader;

/**
 * {}实例化代码块，构造函数之前都会执行
 *
 * result：============
 * Hello
 * c
 * Hello
 * c
 *
 */
public class MyTest5_1_实例化代码块的使用 {

    public static void main(String[] args) {
        C c = new C();
        c = new C();
    }


}


class C {
    {
        System.out.println("Hello");
    }

    public C() {
        System.out.println("c");
    }

}