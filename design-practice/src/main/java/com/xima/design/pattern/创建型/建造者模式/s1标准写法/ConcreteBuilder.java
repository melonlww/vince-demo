package com.xima.design.pattern.创建型.建造者模式.s1标准写法;

public class ConcreteBuilder implements IBuilder{

    Product product = new Product();

    @Override
    public Product build() {
        return product;
    }
}
