package com.xima.design.pattern.行为型.观察者模式_Observer.s2实例_知乎问答;

import java.util.Observable;

public class Zhihu extends Observable {
    private String name = "知乎问答";
    private static final Zhihu zhihu = new Zhihu();

    private Zhihu(){

    }

    public static Zhihu getInstance(){
        return zhihu;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
