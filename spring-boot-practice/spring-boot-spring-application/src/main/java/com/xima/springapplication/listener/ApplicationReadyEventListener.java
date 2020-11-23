package com.xima.springapplication.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * 实现监听springboot的中的事件
 */
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("ApplicationReadyEventListener：" + event.getApplicationContext().getId() + " timestamp: " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
