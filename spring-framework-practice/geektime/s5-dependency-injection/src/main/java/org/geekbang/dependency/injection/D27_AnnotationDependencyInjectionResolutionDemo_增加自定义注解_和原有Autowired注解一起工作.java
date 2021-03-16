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

import org.geekbang.dependency.injection.annotation.InjectedUser;
import org.geekbang.ioc.overview.domain.User5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * 添加新的注解 也实现注入功能
 */
@Configuration
public class D27_AnnotationDependencyInjectionResolutionDemo_增加自定义注解_和原有Autowired注解一起工作 {

    @Autowired
    private User5 user;

    @Inject
    private User5 injectedUser;

    /**
     * 完全自定义注解@InjectedUser
     */
    @InjectedUser
    private Optional<User5> injectedUserOptional;

    /**
     * static 不依赖AnnotationDependencyInjectionResolutionDemo 类 可以自己注册bean
     * 如需提前初始化或者提前注册 可选择性的加上static
     *
     *
     * 标记bean name为AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME， 则不注册原有的AutowiredAnnotationBeanPostProcessor.class
     * 所以会让@Autowired失效，达到替换的目的， 但被标记了@Autowired无法被注册了，慎用！！！
     *
     * {@link AnnotationConfigUtils }
     * if (!registry.containsBeanDefinition(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)) {
     * 		RootBeanDefinition def = new RootBeanDefinition(AutowiredAnnotationBeanPostProcessor.class);
     * 		def.setSource(source);
     * 		beanDefs.add(registerPostProcessor(registry, def, AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME));
     * }
     *
     */
    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        /**
         * static类
         */
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        /**
         *  @Autowired  +  @Inject +  新注解 @InjectedUser
         */
        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
                new LinkedHashSet<>(Arrays.asList(Autowired.class, Inject.class, InjectedUser.class));
        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
        return beanPostProcessor;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D27_AnnotationDependencyInjectionResolutionDemo_增加自定义注解_和原有Autowired注解一起工作.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context7.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D27_AnnotationDependencyInjectionResolutionDemo_增加自定义注解_和原有Autowired注解一起工作 demo = applicationContext.getBean(D27_AnnotationDependencyInjectionResolutionDemo_增加自定义注解_和原有Autowired注解一起工作.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user = " + demo.user);

        // 期待输出 superUser
        System.out.println("demo.injectedUser = " + demo.injectedUser);

        // 期待输出 superUser
        System.out.println("demo.injectedUserOptional = " + demo.injectedUserOptional.get());

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
