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
package org.geekbang.bean.scope;

import org.geekbang.ioc.overview.domain.User5;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Bean 的作用域示例
 *
 *
 * singletonUser id的时间戳都是相同的  prototypeUser每次id时间戳都不同
 *
 * 输出：
 * =======================================
 * 依赖查找：
 * singletonUser = User5{id=74551386733035, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * prototypeUser = User5{id=74551413498835, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * singletonUser = User5{id=74551386733035, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * prototypeUser = User5{id=74551414410584, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * singletonUser = User5{id=74551386733035, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * prototypeUser = User5{id=74551414817865, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 *
 * 
 */
public class D1_BeanScopeDemo_singleton和prototype_通过依赖查找获得bean {

    /**
     * 默认 scope 就是 "singleton"
     */
    @Bean
    public static User5 singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User5 prototypeUser() {
        return createUser();
    }

    private static User5 createUser() {
        User5 user = new User5();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D1_BeanScopeDemo_singleton和prototype_通过依赖查找获得bean.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        System.out.println("依赖查找：");
        scopedBeansByLookup(applicationContext);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            /**
             * singletonUser 是共享 Bean 对象
             */
            User5 singletonUser = applicationContext.getBean("singletonUser", User5.class);
            System.out.println("singletonUser = " + singletonUser);
            /**
             * prototypeUser 是每次依赖查找均生成了新的 Bean 对象
             */
            User5 prototypeUser = applicationContext.getBean("prototypeUser", User5.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }
}