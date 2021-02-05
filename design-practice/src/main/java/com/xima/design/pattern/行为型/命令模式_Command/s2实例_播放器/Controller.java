package com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器;

import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action.IAction;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action) {
        actions.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction action : actions) {
            action.execute();
        }
        actions.clear();
    }
}
