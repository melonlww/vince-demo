package com.xima.design.pattern.创建型.工厂模式.s2工厂方法;

/**
 * 工厂方法
 * 采用工厂模式,对象的创建及初始化职责交给工厂对象。每一个实体必须要对应一个工厂，
 * 这样能够有效的分离对象的创建和使用。和简单工厂来相比，进一步的面向用户对创建实现过程进行了隐藏。
 * 但是每一个实体要去对应一个工厂，这样的做法会使实体增多的时候，对应的工厂也需要不断增加。
 */
public class TestMethodFactory {
    public static void main(String[] args) {
        MethodFactory methodFactory = new PadFactory();
        System.out.println(methodFactory.getPhone());
        methodFactory = new PhoneFactory();
        System.out.println(methodFactory.getPhone());
        methodFactory = new WatchFactory();
        System.out.println(methodFactory.getPhone());
    }
}