package com.xima.design.pattern.行为型.备忘录模式_Memento.s2实例_保存游戏进度;

/**
 * 管理者类
 */
public class Caretaker {
    RoleMemento memento;

    public RoleMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleMemento memento) {
        this.memento = memento;
    }
}