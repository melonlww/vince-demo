package com.xima.springapplication.listener;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * 模拟  before{@link ConfigFileApplicationListener}实现
 *
 * {@link ConfigFileApplicationListener} 是加载配置文件(application.properties)的事件
 * 此代码练习事件加载顺序的关系，
 * 当getOrder优先ConfigFileApplicationListener中的顺序时，environment.getProperty("name")输出为null
 * 当getOrder落后ConfigFileApplicationListener时，environment.getProperty("name")输出为vince
 *
 * 说明要搞清楚事件是干什么的，不然搞错加载顺序会出问题
 */
public class BeforeConfigFileApplicationListener implements EnvironmentPostProcessor, SmartApplicationListener, Ordered {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public int getOrder() {
        //比ConfigFileApplicationListener优先级更高
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty name:" + environment.getProperty("name"));
        }
//        if (event instanceof ApplicationPreparedEvent) {
//            onApplicationPreparedEvent(event);
//        }
    }
}
