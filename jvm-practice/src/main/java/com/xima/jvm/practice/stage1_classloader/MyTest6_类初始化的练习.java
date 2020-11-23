package com.xima.jvm.practice.stage1_classloader;


/**
 * step1. 调用Singleton静态方法getInstance，触发主动调用，将要生成初始化
 * step2.  准备阶段：a = 0 , c=null, b =0
 * step3. 初始化阶段：根据定义顺序执行
 *      step3.1 a = 0 ,
 *      step3.2 c = new Singleton{a++，b++}, -> a = 1, b = 1
 *      step3.3 b = 0
 * 结果 a = 1, b = 0
 */

public class MyTest6_类初始化的练习 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.a);
        System.out.println(singleton.b);
    }
}

class Singleton{
    public static int a = 0;
    public static Singleton c = new Singleton();
    public static int b = 0;

    private Singleton(){
        a++;
        b++;
    }

    public static Singleton getInstance(){
        return c;
    }
}
