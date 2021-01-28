package com.xima.design.pattern.结构型.适配器模式_Adapter.s1类适配;

public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter();
        adapter.output5V();
        //缺点：不符合最少知道原则， 使用继承形式adapter还是可以访问outputAC220方法，最好应该隐藏目标方法
//        adapter.outputAC220();
    }
}
