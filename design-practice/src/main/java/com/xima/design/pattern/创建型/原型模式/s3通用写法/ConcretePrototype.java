package com.xima.design.pattern.创建型.原型模式.s3通用写法;

import java.util.Date;

public class ConcretePrototype implements IPrototype<ConcretePrototype> {

    private int id;

    private int userId;

    private Date examStartTime;

    @Override
    public ConcretePrototype clone() {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setId(this.id);
        concretePrototype.setUserId(this.userId);
        concretePrototype.setExamStartTime(this.examStartTime);
        //todo参数过多的话可以用反射实现，参考s2BeanUtils
        return concretePrototype;
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
        return "ConcretePrototype{" +
                "id=" + id +
                ", userId=" + userId +
                ", examStartTime=" + examStartTime +
                '}';
    }
}
