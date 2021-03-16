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

import org.geekbang.dependency.injection.annotation.MyAutowired;
import org.geekbang.ioc.overview.domain.User5;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * {@link MyAutowired}
 */
@Configuration
public class D25_AnnotationDependencyInjectionResolutionDemo_自定义注解MyAutowired_继承元标注Autowired {

    /**
     *  自定义注解@MyAutowired
     */
    @MyAutowired
    private Optional<User5> myUserOptional;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D25_AnnotationDependencyInjectionResolutionDemo_自定义注解MyAutowired_继承元标注Autowired.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context7.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D25_AnnotationDependencyInjectionResolutionDemo_自定义注解MyAutowired_继承元标注Autowired demo = applicationContext.getBean(D25_AnnotationDependencyInjectionResolutionDemo_自定义注解MyAutowired_继承元标注Autowired.class);

        // 期待输出 superUser
        System.out.println("demo.myUserOptional = " + demo.myUserOptional.get());

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
