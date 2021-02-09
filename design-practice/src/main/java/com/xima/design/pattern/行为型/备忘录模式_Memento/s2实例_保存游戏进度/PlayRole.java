package com.xima.design.pattern.行为型.备忘录模式_Memento.s2实例_保存游戏进度;

/**
 * 游戏角色类
 */
public class PlayRole {
    //生命力
    private int vitality;
    //攻击力
    private int aggressivity;
    //防御力
    private int defencivity;

    public PlayRole() {
    }

    public PlayRole(int vitality, int aggressivity, int defencivity) {
        super();
        this.vitality = vitality;
        this.aggressivity = aggressivity;
        this.defencivity = defencivity;
    }

    public RoleMemento createMemento() {
        RoleMemento memento = new RoleMemento();
        memento.setAggressivity(aggressivity);
        memento.setDefencivity(defencivity);
        memento.setVitality(vitality);
        return memento;
    }

    public void setMemento(RoleMemento memento) {
        this.aggressivity = memento.getAggressivity();
        this.defencivity = memento.getDefencivity();
        this.vitality = memento.getVitality();
    }

    public void showState() {
        System.out.println("攻击力：" + this.aggressivity + "|防御力：" + this.defencivity
                + "|生命力：" + this.vitality);
    }

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
