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

import org.geekbang.ioc.overview.domain.User5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 注解驱动的依赖注入处理过程
 *
 */
@Configuration
public class D23_AnnotationDependencyInjectionResolutionDemo_注解驱动依赖注入的处理过程 {

    /**
     * DefaultListableBeanFactory#resolveDependency
     * 实时注入+通过类型（User.class）依赖查找（处理）
     *
     * DependencyDescriptor ->
     *  必须（required=true）
     *  实时注入（eager=true)
     *  通过类型（User.class）
     *  字段名称（"user"）
     *  是否首要（primary = true)
     */
    @Autowired
    private User5 user;



    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D23_AnnotationDependencyInjectionResolutionDemo_注解驱动依赖注入的处理过程.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context7.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D23_AnnotationDependencyInjectionResolutionDemo_注解驱动依赖注入的处理过程 demo = applicationContext.getBean(D23_AnnotationDependencyInjectionResolutionDemo_注解驱动依赖注入的处理过程.class);


        System.out.println("demo.user = " + demo.user);


        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
