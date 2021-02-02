package com.xima.springframework.ioc.practice.shengsiyuan.annotation.config;

import com.xima.springframework.ioc.practice.shengsiyuan.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean(name="person_zhangsan")
    public Person getPerson(){
        Person person = new Person();
        person.setId(28);
        person.setName("zhangsan");
        return person;
    }
}
