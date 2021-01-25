package com.xima.design.pattern.创建型.建造者模式_Builder.s1大致用法;

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
