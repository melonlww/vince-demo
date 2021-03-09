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

import org.geekbang.ioc.overview.domain.User3;
import org.geekbang.ioc.overview.domain.User4;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入数组workCities字段
 *
 * 打印：
 * SuperUser{address='上海'} User4{id=1, name='阿奶', city=HANGZHOU, workCities=[BEIJING, HANGZHOU], configFileLocation=class path resource [META-INF/user-config.properties]}
 *
 *
 */
public class D17_DependencyLookupDemo_自动注入_数组字段_Spring在注入时会自动转换 {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        /** user4:
         *     private City[] workCities;
         *
         *  xml:
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context6.xml");
        lookupByType(beanFactory);
    }


    private static void lookupByType(BeanFactory beanFactory) {
        User4 user =  beanFactory.getBean(User4.class);
        System.out.println("实时查找：" + user);
    }
}
