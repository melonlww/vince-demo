package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

/**
 * 对运算符进行解释
 */
public abstract class OperatorExpression extends ArithmeticExpression {
    protected ArithmeticExpression mArithmeticExpression1, mArithmeticExpression2;

    public OperatorExpression(ArithmeticExpression arithmeticExpression1, ArithmeticExpression arithmeticExpression2) {
        mArithmeticExpression1 = arithmeticExpression1;
        mArithmeticExpression2 = arithmeticExpression2;
    }
}