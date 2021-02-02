package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("liww820");

        StudentDao studentDao = new StudentDao(ds);
        List<?> list = studentDao.selectAll();

        list.stream().forEach(System.out::println);
    }
}
