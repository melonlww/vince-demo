package com.xima.design.pattern.行为型.观察者模式_Observer.s3_guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {

    @Subscribe
    public void observer(Pojo str) {
        System.out.println("执行了observer方法，参数为" + str);
    }

    @Subscribe
    public void observerVo(Vo str) {
        System.out.println("执行了observerVo方法，参数为" + str);
    }
}
