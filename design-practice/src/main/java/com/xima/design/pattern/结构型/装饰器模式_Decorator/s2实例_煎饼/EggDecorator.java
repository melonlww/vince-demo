package com.xima.design.pattern.结构型.装饰器模式_Decorator.s2实例_煎饼;

public class EggDecorator extends BatterCakeDecorator{

    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    protected String getMsg(){
        return super.getMsg() + "1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
