package com.xima.design.pattern.创建型.建造者模式.s1标准写法;

public class Product {

    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
