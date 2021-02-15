package com.xima.design.pattern.行为型.观察者模式_Observer.s3_guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);

        eventBus.post(new Pojo("Li"));
        eventBus.post(new Vo("jerry"));
    }
}
