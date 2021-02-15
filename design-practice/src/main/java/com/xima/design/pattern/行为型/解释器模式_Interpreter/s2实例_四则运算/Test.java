package com.xima.design.pattern.行为型.解释器模式_Interpreter.s2实例_四则运算;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("10 + 30");
        System.out.println(calculator.calculate());
    }
}
