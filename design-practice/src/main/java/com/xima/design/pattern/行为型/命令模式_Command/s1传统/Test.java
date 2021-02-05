package com.xima.design.pattern.行为型.命令模式_Command.s1传统;

public class Test {

    public static void main(String[] args) {
        ICommand cmd= new ConcreteCommand();
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
