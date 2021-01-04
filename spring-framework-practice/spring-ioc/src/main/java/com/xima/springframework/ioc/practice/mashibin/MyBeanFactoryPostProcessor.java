package com.xima.springframework.ioc.practice.mashibin;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition person = beanFactory.getBeanDefinition("person");
        MutablePropertyValues mutablePropertyValues = person.getPropertyValues();
        System.out.println(mutablePropertyValues.getPropertyValueList());
    }
}
