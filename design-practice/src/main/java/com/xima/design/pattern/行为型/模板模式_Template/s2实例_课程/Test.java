package com.xima.design.pattern.行为型.模板模式_Template.s2实例_课程;

public class Test {

    public static void main(String[] args) {
        System.out.println("=======java课程==========");
        JavaCourse java= new JavaCourse();
        java.setNeedCheckHomework(true);
        java.createCourse();

        System.out.println("=======python==========");
        PythonCourse python = new PythonCourse();
        python.createCourse();


    }
}
