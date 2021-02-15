package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.core.Event;

public interface EventListener {

    void onClick(Event e);

    void onMove(Event e);
}
