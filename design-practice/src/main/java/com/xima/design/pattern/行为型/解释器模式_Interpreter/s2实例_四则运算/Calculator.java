package com.xima.design.pattern.行为型.解释器模式_Interpreter.s2实例_四则运算;

import java.util.Stack;

public class Calculator {

    //声明一个Stack栈，存储并操作所有相关的解释器
    protected Stack<ArithmeticExpression> mArithmeticExpressionStack = new Stack<>();

    public Calculator(String expression) {
        //声明两个ArithmeticExpression类型的临时变量，存储运算符左右两边的数字解释器
        ArithmeticExpression arithmeticExpression1, arithmeticExpression2;

        //根据空格分隔表达式字符串
        String[] elements = expression.split(" ");

        //循环遍历表达式元素数组
        for (int i = 0; i < elements.length; ++i) {
            switch (elements[i].charAt(0)) {
                //如果是运算符
                case '*':
                    //将栈中的解释器弹出作为运算符号左边的解释器
                    arithmeticExpression1 = mArithmeticExpressionStack.pop();
                    //同时将运算符号数组下标下一个元素构造为一个数字解析器
                    arithmeticExpression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mArithmeticExpressionStack.push(new MultiplyExpression(arithmeticExpression1, arithmeticExpression2));
                    break;
                case '/':
                    arithmeticExpression1 = mArithmeticExpressionStack.pop();
                    arithmeticExpression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mArithmeticExpressionStack.push(new DivideExpression(arithmeticExpression1, arithmeticExpression2));
                    break;
                case '+':
                    arithmeticExpression1 = mArithmeticExpressionStack.pop();
                    arithmeticExpression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mArithmeticExpressionStack.push(new AdditionExpression(arithmeticExpression1, arithmeticExpression2));
                    break;
                case '-':
                    arithmeticExpression1 = mArithmeticExpressionStack.pop();
                    arithmeticExpression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mArithmeticExpressionStack.push(new SubtractionExpression(arithmeticExpression1, arithmeticExpression2));
                    break;
                default:
                    //如果不是运算符，则是数字，直接构造数字解释器并压入栈
                    mArithmeticExpressionStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    //计算结果
    public int calculate() {
        return mArithmeticExpressionStack.pop().interpret();
    }
}