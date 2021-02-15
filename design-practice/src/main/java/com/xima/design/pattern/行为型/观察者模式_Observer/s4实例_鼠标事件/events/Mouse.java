package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.core.EventObservable;

public class Mouse extends EventObservable {

    public void click() {
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void move() {
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
