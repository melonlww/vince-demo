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
package org.geekbang.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置作为依赖来源示例
 *
 * 必须要加配置项：
 * @Configuration
 * @PropertySource(value = "META-INF/default.properties", encoding = "UTF-8")
 *
 */
@Configuration
@PropertySource(value = "META-INF/default.properties", encoding = "UTF-8")
public class D5_ExternalConfigurationDependencySourceDemo_外部化配置 {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${usr.name}")
    private String name;

    /**
     * 系统默认参数名    user.name
     */
    @Value("${user.name}")
    private String userName;

    @Value("${user.resource:classpath://default222.properties}")
    private Resource resource;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D5_ExternalConfigurationDependencySourceDemo_外部化配置.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 ExternalConfigurationDependencySourceDemo Bean
        D5_ExternalConfigurationDependencySourceDemo_外部化配置 demo = applicationContext.getBean(D5_ExternalConfigurationDependencySourceDemo_外部化配置.class);

        System.out.println("demo.id = " + demo.id);
        System.out.println("demo.name = " + demo.name);
        System.out.println("demo.userName = " + demo.userName);
        System.out.println("demo.resource = " + demo.resource);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
