package org.geekbang.dependency.injection;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 {@link Aware} 接口回调的依赖注入示例
 *
 */
public class D15_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_注解 {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    public ApplicationContext applicationContext;


    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        context.register(D15_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_注解.class);

        // 启动 Spring 应用上下文
        context.refresh();


        /**
         * Config类是一个SpringBean
         */
        D15_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_注解 d14AwareInterfaceDependencyInjectionDemo自动注入内建类注解 = context.getBean(D15_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_注解.class);

        System.out.println(d14AwareInterfaceDependencyInjectionDemo自动注入内建类注解.beanFactory == context.getBeanFactory());
        System.out.println(d14AwareInterfaceDependencyInjectionDemo自动注入内建类注解.applicationContext == context);

        // 显示地关闭 Spring 应用上下文
        context.close();
    }

}
