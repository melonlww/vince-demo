package com.xima.design.pattern.创建型.建造者模式_Builder.s3链式;

public class Test {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("设计模式").addPpt("ppt课件").addVideo("录播视频");
        System.out.println(builder.build());
    }
}
