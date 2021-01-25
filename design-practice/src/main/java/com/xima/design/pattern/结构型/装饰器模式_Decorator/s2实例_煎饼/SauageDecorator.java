package com.xima.design.pattern.结构型.装饰器模式_Decorator.s2实例_煎饼;

public class SauageDecorator extends BatterCakeDecorator{

    public SauageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    protected String getMsg(){
        return super.getMsg() + "1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 3;
    }
}
