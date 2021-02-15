package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

/**
 * 对数字进行解释
 */
public class NumExpression extends ArithmeticExpression {
    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}