package org.geekbang.dependency.injection;

import org.geekbang.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 实际开发中不推荐使用autowire的形式自动注入
 *
 * "byName" Autowiring 依赖 Setter 方法注入示例
 *
 *  通过autowire="byType"方式注入，根据名称查名称为user的bean，所以找到dependency-lookup-context4.xml文件中配置的user
 *
 *  打印：
 *  UserHolder{user=User{id=1, name='阿奶'}}
 */
public class D4_AutoWiringByNameDependencySetterInjectionDemo_自动注入_autoWiring_byName {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);

    }

}
