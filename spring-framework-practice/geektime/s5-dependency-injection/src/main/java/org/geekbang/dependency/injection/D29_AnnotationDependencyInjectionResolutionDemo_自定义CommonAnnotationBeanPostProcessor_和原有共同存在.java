/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geekbang.dependency.injection;

import org.geekbang.dependency.injection.annotation.MyPostConstruct;
import org.geekbang.dependency.injection.domain.User6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * 自定义的注解@MyPostConstruct 和原有注解@PreDestroy都起效果
 *
 *
 * 打印
 * @MyPostConstruct : UserFactory 初始化中...
 * @MyPostConstruct : UserFactory 初始化中...
 * demo.user = SuperUser{address='上海'} User6{id=1, name='阿奶', city=HANGZHOU, workCities=[BEIJING, HANGZHOU], lifeCities=[BEIJING, SHANGHAI], configFileLocation=class path resource [META-INF/user-config.properties]}
 * @PreDestroy : UserFactory 销毁中...
 * @PreDestroy : UserFactory 销毁中...
 *
 * @MyPostConstruct : UserFactory 初始化中...
 */
@Configuration
public class D29_AnnotationDependencyInjectionResolutionDemo_自定义CommonAnnotationBeanPostProcessor_和原有共同存在 {

    @Resource
    private User6 user;

    /**
     * 自定义bean（CommonAnnotationBeanPostProcessor）， spring容器中有两个CommonAnnotationBeanPostProcessor
     */
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static CommonAnnotationBeanPostProcessor beanPostProcessor() {
        /**
         * 如果你想你的bean优先加载的话，你可以在你@Bean方法声明的时候，将方法设置成static
         */
        CommonAnnotationBeanPostProcessor beanPostProcessor = new CommonAnnotationBeanPostProcessor();
        beanPostProcessor.setInitAnnotationType(MyPostConstruct.class);
//        beanPostProcessor.setDestroyAnnotationType(MyPreDestroy.class);
        return beanPostProcessor;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D29_AnnotationDependencyInjectionResolutionDemo_自定义CommonAnnotationBeanPostProcessor_和原有共同存在.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context8.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D29_AnnotationDependencyInjectionResolutionDemo_自定义CommonAnnotationBeanPostProcessor_和原有共同存在 demo = applicationContext.getBean(D29_AnnotationDependencyInjectionResolutionDemo_自定义CommonAnnotationBeanPostProcessor_和原有共同存在.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user = " + demo.user);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
