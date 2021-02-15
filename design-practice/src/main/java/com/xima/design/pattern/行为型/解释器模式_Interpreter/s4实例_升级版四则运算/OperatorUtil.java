package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

public class OperatorUtil {
    /**
     * 判断是操作符
     */
    public static boolean isOperator(String symbol) {
        return (symbol.equals("(") || symbol.equals(")") || symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    /**
     * 判断是数据
     */
    public static boolean isNum(String symbol) {
        return !isOperator(symbol);
    }

    /**
     * 判断是左括号
     */
    public static boolean isLeftParentheses(String symbol) {
        return (symbol.equals("("));
    }

    /**
     * 判断是右括号
     */
    public static boolean isRightParentheses(String symbol) {
        return (symbol.equals(")"));
    }

    /**
     * 得到操作符的优先级
     */
    public static int getPriority(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 999;
        }
    }

    /**
     * 得到操作符对应的解释器
     */
    public static ArithmeticExpression getInterpreter(ArithmeticExpression left, ArithmeticExpression right, String symbol) {

        if (symbol.equals("+")) {
            return new AdditionExpression(left, right);
        } else if (symbol.equals("-")) {
            return new SubtractionExpression(left, right);
        } else if (symbol.equals("*")) {
            return new MultiplyExpression(left, right);
        } else if (symbol.equals("/")) {
            return new DivideExpression(left, right);
        }
        return null;
    }
}