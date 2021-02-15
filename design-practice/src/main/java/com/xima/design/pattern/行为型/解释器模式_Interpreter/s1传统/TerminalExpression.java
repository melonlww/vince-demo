package com.xima.design.pattern.行为型.解释器模式_Interpreter.s1传统;

/**
 * 表达式接口的实体类
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}