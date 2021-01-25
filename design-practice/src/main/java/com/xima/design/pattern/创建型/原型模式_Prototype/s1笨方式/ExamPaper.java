package com.xima.design.pattern.创建型.原型模式_Prototype.s1笨方式;

import java.util.Date;

public class ExamPaper {

    private int id;

    private int userId;

    private Date examStartTime;

    public ExamPaper copy(){
        ExamPaper examPaper = new ExamPaper();
        examPaper.setId(this.id);
        examPaper.setUserId(this.userId);
        examPaper.setExamStartTime(this.examStartTime);
        return examPaper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "id=" + id +
                ", userId=" + userId +
                ", examStartTime=" + examStartTime +
                '}';
    }
}
