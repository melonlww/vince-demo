package com.xima.design.pattern.行为型.解释器模式_Interpreter.s4实例_升级版四则运算;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String str = "100 + 3 * 10 - 2 ";
        String[] inOrderArrays = XimaCalculator.strToArray(str);
        System.out.println("解析成的后缀表达式：" + Arrays.toString(inOrderArrays));
        System.out.println("result: " + new XimaCalculator(str).calculate());
    }
}
