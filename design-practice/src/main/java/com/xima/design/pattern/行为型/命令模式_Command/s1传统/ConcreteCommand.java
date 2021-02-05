package com.xima.design.pattern.行为型.命令模式_Command.s1传统;

public class ConcreteCommand implements ICommand {
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
