package com.xima.design.pattern.创建型.工厂模式.s3抽象工厂;

/**
 * 抽象工厂
 * 抽象工厂模式（Abstract FactoryPattern）是围绕一个超级工厂创建其他工厂。
 * 该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory phoneFactory = new AppleFactory();
        System.out.println(phoneFactory.getPad());
    }
}