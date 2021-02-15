package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.core.Event;

public class MouseEventCallback {

    public void onClick(Event e) {
        System.out.println("触发鼠标单击事件,e:" + e);
    }
}
