package com.xima.springapplication.context;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.Ordered;

public class AnnotationConfigServletWebServerApplicationContextInitializer implements ApplicationContextInitializer<AnnotationConfigServletWebServerApplicationContext>, Ordered {
    @Override
    public void initialize(AnnotationConfigServletWebServerApplicationContext applicationContext) {
        System.out.println("AnnotationConfigServletWebServerApplicationContext id = " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
