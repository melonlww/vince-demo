package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventObservable {

    protected Map<String, Event> events = new HashMap<>();

    public void addListener(String eventType, Object target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }
}
