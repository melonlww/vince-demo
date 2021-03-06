package com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.action;

import com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器.XimaPlayer;

public class SpeedAction implements IAction{

    private XimaPlayer player;

    public SpeedAction(XimaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.speed();
    }
}
