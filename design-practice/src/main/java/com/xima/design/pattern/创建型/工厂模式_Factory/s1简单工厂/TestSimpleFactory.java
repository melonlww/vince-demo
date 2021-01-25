package com.xima.design.pattern.创建型.工厂模式_Factory.s1简单工厂;

/**
 * 简单工厂
 *
 * 简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类。
 * 它的优点就是能够根据一个批量生产对象，对于用于操作更简单，避免了用户直接去进行new的动作，
 * 同时它也是其它两种模式的思想模型。相对而言，简单工厂模式，传入参数也是一个缺点，
 * 不能够直接去选择生产什么对象。
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        System.out.println(SimpleFactory.test("XiaoMi"));
    }
}