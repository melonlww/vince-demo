package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MyDataSource extends DriverManagerDataSource {
    private final static MyDataSource instance = new MyDataSource();

    private MyDataSource(){
        this.setUrl("jdbc:mysql://localhost:3306/test");
        this.setUsername("root");
        this.setPassword("liww820");
    }

    public static MyDataSource getInstance(){
        return instance;
    }
}
