package com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器;

import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action.PauseAction;
import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action.PlayAction;
import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action.SpeedAction;
import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action.StopAction;

public class Test {
    public static void main(String[] args) {
        XimaPlayer player = new XimaPlayer();
        Controller controller = new Controller();

        controller.execute(new PlayAction(player));

        controller.addAction(new PlayAction(player));
        controller.addAction(new PauseAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));
        controller.executes();
    }
}
