package com.xima.design.pattern.行为型.观察者模式_Observer.s2实例_知乎问答;

public class Test {
    public static void main(String[] args) {
        Zhihu zhihu = Zhihu.getInstance();
        Teacher tom =new Teacher("Tom");
        Teacher li =new Teacher("Li");

        zhihu.addObserver(tom);
        zhihu.addObserver(li);

        //用户行为
        Question question= new Question();
        question.setUserName("张三");
        question.setContent("观察者模式怎么用");
        zhihu.publishQuestion(question);
    }
}
