package com.xima.design.pattern.行为型.策略模式_Strategy.s1传统;

//上下文环境
public class Context {
    private IStrategy mStrategy;

    public Context(IStrategy strategy){
        this.mStrategy = strategy;
    }

    public void algorithm(){
        this.mStrategy.algorithm();
    }
}
