package com.xima.design.pattern.行为型.备忘录模式_Memento.s2实例_保存游戏进度;

public class Test {
    public static void main(String[] args) {
        // 测试程序
        // 新建角色
        PlayRole role = new PlayRole(100, 100, 100);
        // 新建管理者
        Caretaker taker = new Caretaker();
        // 角色初始状态
        System.out.println("游戏刚开始，角色各属性:");
        role.showState();
        // 利用备忘录模式保存当前状态
        System.out.println("\n【保存游戏状态！】\n");
        taker.setMemento(role.createMemento());
        // 大战过后，角色能力值下降
        role.setAggressivity(20);
        role.setDefencivity(30);
        role.setVitality(0);
        System.out.println("与Boss对战后，角色各项能力已大大下降:");
        role.showState();
        // 恢复保存的角色状态
        role.setMemento(taker.getMemento());
        System.out.println("\n【恢复保存的角色状态！】");
        System.out.println("\n恢复后角色的当前状态：");
        role.showState();
    }
}