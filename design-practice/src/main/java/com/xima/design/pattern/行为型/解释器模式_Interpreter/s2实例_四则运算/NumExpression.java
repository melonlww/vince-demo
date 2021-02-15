package com.xima.design.pattern.行为型.解释器模式_Interpreter.s2实例_四则运算;

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