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
package org.geekbang.bean.scope.web;

import org.geekbang.ioc.overview.domain.User7;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.support.ServletContextScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 增加Web MVC 配置类
 *
 * maven打war包:
 *      cd ~/practice/code/vince-demo/spring-framework-practice/geektime
 *      mvn clean package
 *
 * 启动war
 *      cd ~/practice/code/vince-demo/spring-framework-practice/geektime/s7-bean-scope/target
 *      java -jar s7-bean-scope-1.0-SNAPSHOT-war-exec.jar
 *
 * debug调试
 *      java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9527 s7-bean-scope-1.0-SNAPSHOT-war-exec.jar
 *
 * 请求：http://localhost:8080/index_application.html
 *
 * @ApplicationScope 直接存于servletContext中
 * 代码： {@link ServletContextScope}
 *  @Override
 *  public Object get(String name, ObjectFactory<?> objectFactory) {
 * 		Object scopedObject = this.servletContext.getAttribute(name);
 * 		if (scopedObject == null) {
 * 			scopedObject = objectFactory.getObject();
 * 			this.servletContext.setAttribute(name, scopedObject);
 *        }
 * 		return scopedObject;
 *    }
 *
 */
@Configuration
@EnableWebMvc
public class D7_WebConfiguration_application_Bean作用域 {

    @Bean
    @ApplicationScope
    public User7 user7() {
        User7 user = new User7();
        user.setId(System.nanoTime());
        user.setName("小pp");
        return user;
    }

}
