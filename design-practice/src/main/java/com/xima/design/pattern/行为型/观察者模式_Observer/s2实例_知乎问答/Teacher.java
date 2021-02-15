package com.xima.design.pattern.行为型.观察者模式_Observer.s2实例_知乎问答;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Zhihu zhihu = (Zhihu) o;
        Question question = (Question) arg;
        System.out.println("========================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自" + zhihu.getName() + "的提问，希望您能解答\n" +
                "问题内容："+ question.getContent() + "\n" +
                "提问者："+ question.getUserName() + "\n");

    }
}
