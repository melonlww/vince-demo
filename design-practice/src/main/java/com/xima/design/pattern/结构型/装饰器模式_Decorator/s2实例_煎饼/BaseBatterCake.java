package com.xima.design.pattern.结构型.装饰器模式_Decorator.s2实例_煎饼;

public class BaseBatterCake extends BatterCake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
