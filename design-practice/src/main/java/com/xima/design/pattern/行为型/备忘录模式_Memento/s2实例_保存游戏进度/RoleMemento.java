package com.xima.design.pattern.行为型.备忘录模式_Memento.s2实例_保存游戏进度;

/**
 * 备忘录类
 */
public class RoleMemento {
    //生命力
    private int vitality;
    //攻击力
    private int aggressivity;
    //防御力
    private int defencivity;

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public int getDefencivity() {
        return defencivity;
    }

    public void setDefencivity(int defencivity) {
        this.defencivity = defencivity;
    }
}