package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.core;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.EventListener;

import java.lang.reflect.Method;

public class Event {
    //事件源，动作由谁发出的
    private Object source;
    //事件触发，要通知谁（观察者）
    private EventListener target;
    //观察者给的回应
    private Method callback;
    //事件的名称
    private String trigger;
    //事件触发的事件
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public EventListener getTarget() {
        return target;
    }

    public Event setTarget(EventListener target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
