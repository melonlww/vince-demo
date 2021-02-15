package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

public class AdditionExpression extends OperatorExpression {
    public AdditionExpression(ArithmeticExpression arithmeticExpression1, ArithmeticExpression arithmeticExpression2) {
        super(arithmeticExpression1, arithmeticExpression2);
    }

    @Override
    public int interpret() {
        return mArithmeticExpression1.interpret() + mArithmeticExpression2.interpret();
    }
}