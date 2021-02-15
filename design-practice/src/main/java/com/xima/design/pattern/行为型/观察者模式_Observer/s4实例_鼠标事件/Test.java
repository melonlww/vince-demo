package com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件;

import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.Mouse;
import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.MouseEventCallback;
import com.xima.design.pattern.行为型.观察者模式_Observer.s4实例_鼠标事件.events.MouseEventType;

public class Test {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, callback);

        mouse.click();
    }
}
