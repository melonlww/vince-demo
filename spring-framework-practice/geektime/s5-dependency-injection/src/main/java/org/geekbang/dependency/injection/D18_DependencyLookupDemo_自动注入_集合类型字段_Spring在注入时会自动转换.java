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
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入集合类型lifeCities字段
 *
 * 打印：
 * SuperUser{address='上海'} User5{id=1, name='阿奶', city=HANGZHOU, workCities=[BEIJING, HANGZHOU], lifeCities=[BEIJING, SHANGHAI], configFileLocation=class path resource [META-INF/user-config.properties]}
 *
 *
 */
public class D18_DependencyLookupDemo_自动注入_集合类型字段_Spring在注入时会自动转换 {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        /** user3:
         *     List<City> lifeCities;
         *
         *  xml:
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context7.xml");
        lookupByType(beanFactory);
    }


    private static void lookupByType(BeanFactory beanFactory) {
        User5 user =  beanFactory.getBean(User5.class);
        System.out.println("实时查找：" + user);
    }
}
