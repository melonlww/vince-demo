package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.Mouse;
import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.MouseEventListener;
import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.MouseEventType;

public class Test {
    public static void main(String[] args) {
        MouseEventListener listener = new MouseEventListener();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, listener);
        mouse.addListener(MouseEventType.ON_MOVE, listener);

        mouse.click();
        mouse.move();
    }
}
