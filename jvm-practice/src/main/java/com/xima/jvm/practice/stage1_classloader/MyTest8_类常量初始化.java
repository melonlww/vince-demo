package com.xima.jvm.practice.stage1_classloader;

/**
 * result============
 * 3
 */
public class MyTest8_类常量初始化 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest{
    public static final int x = 3;

    static{
        System.out.println("FinalTest static block");
    }
}