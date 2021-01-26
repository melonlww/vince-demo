package com.xima.design.pattern.结构型.享元模式_Flyweight.s1传统;

/**
 * 具体享元角色
 */
public class ConcreteFlyweight implements IFlyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Object address: " + System.identityHashCode(this));
        System.out.println("IntrinsicState: " + this.intrinsicState);
        System.out.println("ExtrinsicState: " + extrinsicState);
    }


}
