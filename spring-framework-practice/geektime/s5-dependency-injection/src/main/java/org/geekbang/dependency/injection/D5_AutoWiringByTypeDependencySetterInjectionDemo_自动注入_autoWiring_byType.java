package org.geekbang.dependency.injection;

import org.geekbang.dependency.injection.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 实际开发中不推荐使用autowire的形式自动注入
 *
 * "byName" Autowiring 依赖 Setter 方法注入示例
 *
 * 通过autowire="byType"方式注入，根据类型会找到User类型的bean，查到有两个：superUser，user，
 * 因为dependency-lookup-context4.xml配置文件中将superUser被标注为primary，所以注入此次superUser
 *
 * 打印：
 * UserHolder{user=SuperUser{address='上海'} User{id=1, name='阿奶'}}
 *
 */
public class D5_AutoWiringByTypeDependencySetterInjectionDemo_自动注入_autoWiring_byType {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection2.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);

    }

}
