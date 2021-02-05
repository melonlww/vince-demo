package com.xima.design.pattern.行为型.命令模式_Command.s1传统;

//请求者
public class Invoker {
    private ICommand mCmd;

    public Invoker(ICommand mCmd) {
        this.mCmd = mCmd;
    }

    public void action(){
        this.mCmd.execute();
    }
}
