package com.xima.design.pattern.行为型.命令模式_Command.s2实例_播放器;

public class XimaPlayer {

    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("拖动进度条");
    }


    public void stop(){
        System.out.println("停止播放");
    }

    public void pause(){
        System.out.println("暂停播放");
    }
}
