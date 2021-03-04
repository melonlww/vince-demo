package org.geekbang.dependency.injection;

import org.geekbang.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 API 实现依赖 Setter 方法注入示例
 *
 */
public class D3_ApiDependencySetterInjectionDemo_手动注入_by_API方式_注册BeanDefinition {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 生成 UserHolder 的 BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        /**
         * 注册 UserHolder 的 BeanDefinition
         */
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context4.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 为 {@link UserHolder} 生成 {@link BeanDefinition}
     *
     * @return
     */
    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        /**
         * addPropertyReference方法 相当于xml配置中  ref="superUser"
         */
        definitionBuilder.addPropertyReference("user", "superUser");
        return definitionBuilder.getBeanDefinition();
    }
}
