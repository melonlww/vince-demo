package com.xima.design.pattern.行为型.模板模式_Template.s3实例_orm框架;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao(MyDataSource.getInstance());
        List<?> list = studentDao.selectAll();

        list.stream().forEach(System.out::println);
    }
}
