package com.xima.springframework.ioc.practice.mashibin;

import com.xima.springframework.ioc.practice.mashibin.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanNameAware 和 EnvironmentAware 会在不同类被初始化执行
 *
 * BeanNameAware:
 * -------------------------------------------------
 * AbstractAutowireCapableBeanFactory
 *
 * doCreateBean(){
 *      exposedObject = initializeBean(beanName, exposedObject, mbd);
 * }
 *
 * private void invokeAwareMethods(final String beanName, final Object bean) {
 * 		if (bean instanceof Aware) {
 * 			if (bean instanceof BeanNameAware) {
 * 				((BeanNameAware) bean).setBeanName(beanName);
 *                        }
 * 			if (bean instanceof BeanClassLoaderAware) {
 * 				ClassLoader bcl = getBeanClassLoader();
 * 				if (bcl != null) {
 * 					((BeanClassLoaderAware) bean).setBeanClassLoader(bcl);
 *                }
 *            }
 * 			if (bean instanceof BeanFactoryAware) {
 * 				((BeanFactoryAware) bean).setBeanFactory(AbstractAutowireCapableBeanFactory.this);
 *            }* 		}
 * 	}
 *
 *
 * 	EnvironmentAware:
 *  -------------------------------------------------
 *
 *  AbstractAutowireCapableBeanFactory # applyBeanPostProcessorsBeforeInitialization
 *
 *  private void invokeAwareInterfaces(Object bean) {
 * 		if (bean instanceof EnvironmentAware) {
 * 			((EnvironmentAware) bean).setEnvironment(this.applicationContext.getEnvironment());
 *                }
 * 		if (bean instanceof EmbeddedValueResolverAware) {
 * 			((EmbeddedValueResolverAware) bean).setEmbeddedValueResolver(this.embeddedValueResolver);
 *        }
 * 		if (bean instanceof ResourceLoaderAware) {
 * 			((ResourceLoaderAware) bean).setResourceLoader(this.applicationContext);
 *        }
 * 		if (bean instanceof ApplicationEventPublisherAware) {
 * 			((ApplicationEventPublisherAware) bean).setApplicationEventPublisher(this.applicationContext);
 *        }
 * 		if (bean instanceof MessageSourceAware) {
 * 			((MessageSourceAware) bean).setMessageSource(this.applicationContext);
 *        }
 * 		if (bean instanceof ApplicationContextAware) {
 * 			((ApplicationContextAware) bean).setApplicationContext(this.applicationContext);
 *        }
 *   }
 *
 *
 */
public class SpringClient2_使用Aware {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean.getBeanName());
        System.out.println(bean.getEnvironment());
    }
}
