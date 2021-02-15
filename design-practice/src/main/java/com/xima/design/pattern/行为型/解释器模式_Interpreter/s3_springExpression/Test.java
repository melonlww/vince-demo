package com.xima.design.pattern.行为型.解释器模式_Interpreter.s3_springExpression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10+40");
        System.out.println(expression.getValue());
    }
}
