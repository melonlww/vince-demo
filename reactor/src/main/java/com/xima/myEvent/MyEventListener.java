package com.xima.myEvent;

public interface MyEventListener {
    void onNewEvent(MyEventSource.MyEvent event);

    void onEventStopped();
}
