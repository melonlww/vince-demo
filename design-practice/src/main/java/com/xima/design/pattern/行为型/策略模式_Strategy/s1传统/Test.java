package com.xima.design.pattern.行为型.策略模式_Strategy.s1传统;

public class Test {

    public static void main(String[] args) {
        //选择一个具体策略
        IStrategy strategy = new ConcreteIStrategyA();
        //来一个上下文环境
        Context context = new Context(strategy);
        //客户端直接让上下文环境执行算法
        context.algorithm();
    }
}
