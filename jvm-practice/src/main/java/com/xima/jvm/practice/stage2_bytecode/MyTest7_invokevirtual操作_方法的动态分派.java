package com.xima.jvm.practice.stage2_bytecode;

import java.util.Date;

/**
 * 针对方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table， vtable）
 * 针对与invokeinterface指令来说，虚拟机会建立一个接口方法表的数据结构（interface method table， itable）
 */
public class MyTest7_invokevirtual操作_方法的动态分派 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {

    public void test(String str){
        System.out.println("animal str");
    }

    public void test(Date date){
        System.out.println("animal date");
    }
}

class Dog extends Animal{
    @Override
    public void test(String str){
        System.out.println("dog str");
    }

    @Override
    public void test(Date date){
        System.out.println("dog date");
    }

}