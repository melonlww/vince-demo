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
package org.geekbang.dependency.lookup;

import org.geekbang.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找示例
 *
 * 单个bean
 * BeanFactoryUtils.beanOfTypeIncludingAncestors
 *
 * 集合bean
 * BeanFactoryUtils.beansOfTypeIncludingAncestors
 *
 */
public class D5_HierarchicalDependencyLookupDemo_层次性_用BeanFactoryUtils递归查找是否包含Bean {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
        applicationContext.register(D1_ObjectProviderDemo_通过ObjectProvider_延迟查找Bean.class);

        /**
         * 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
         */
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        /**
         * 2. 设置 Parent BeanFactory
         */
        HierarchicalBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("当前 BeanFactory 的 Parent BeanFactory ： " + beanFactory.getParentBeanFactory());


        displayContainsBeanByBeanFactoryUtils(beanFactory, User.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 关闭应用上下文
        applicationContext.close();
    }

    private static ConfigurableListableBeanFactory createParentBeanFactory() {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "classpath:/META-INF/dependency-lookup-context4.xml";
        // 加载配置
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }

    private static <T> void displayContainsBeanByBeanFactoryUtils(ListableBeanFactory beanFactory, Class<T> type) {
        System.out.printf("BeanFactoryUtils递归查找 BeanFactory[%s] 是否包含 Local Bean[type : %s] : %s\n", beanFactory, type,
                BeanFactoryUtils.beansOfTypeIncludingAncestors(beanFactory, type));
        //单个bean
//        BeanFactoryUtils.beanOfTypeIncludingAncestors
        //集合bean
//        BeanFactoryUtils.beansOfTypeIncludingAncestors
    }


}
