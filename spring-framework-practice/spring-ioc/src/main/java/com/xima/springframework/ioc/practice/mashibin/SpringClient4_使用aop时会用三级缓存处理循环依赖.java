package com.xima.springframework.ioc.practice.mashibin;

import com.xima.springframework.ioc.practice.mashibin.aop.AppConfig;
import com.xima.springframework.ioc.practice.mashibin.bean.Boy;
import com.xima.springframework.ioc.practice.mashibin.bean.Girl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用aop时，会使用三级缓存放的lambda表达式，来完成代理对象的覆盖过程
 *
 * AbstractAutowireCapableBeanFactory#
 * protected Object getEarlyBeanReference(String beanName, RootBeanDefinition mbd, Object bean) {
 * 		Object exposedObject = bean;
 * 		if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
 * 			for (BeanPostProcessor bp : getBeanPostProcessors()) {
 * 				if (bp instanceof SmartInstantiationAwareBeanPostProcessor) {
 * 					SmartInstantiationAwareBeanPostProcessor ibp = (SmartInstantiationAwareBeanPostProcessor) bp;
 * 					exposedObject = ibp.getEarlyBeanReference(exposedObject, beanName);
 *                                }*                    }
 * 		}
 * 		return exposedObject;
 * 	}
 *
 *
 */
public class SpringClient4_使用aop时会用三级缓存处理循环依赖 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy", Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy();
        girl.buy();
    }
}
