package com.xima.design.pattern.创建型.原型模式_Prototype.s1笨方式;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setId(1);
        examPaper.setUserId(2);
        examPaper.setExamStartTime(new Date());

        System.out.println(examPaper);
        System.out.println(examPaper.copy());
    }
}
