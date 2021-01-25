package com.xima.design.pattern.结构型.装饰器模式_Decorator.s2实例_煎饼;

public class Test {

    public static void main(String[] args) {
        BatterCake batterCake = new BaseBatterCake();
        batterCake = new EggDecorator(batterCake);
        batterCake = new SauageDecorator(batterCake);
        System.out.println(batterCake.getMsg() + ",总价：" + batterCake.getPrice());
    }
}
