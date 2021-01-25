package com.xima.design.pattern.创建型.建造者模式_Builder.s2简单写法;

public class CourseBuilder{
    private Course course = new Course();

    public void addName(String name){
        course.setName(name);
    }

    public void addPpt(String ppt){
        course.setPpt(ppt);
    }

    public void addVideo(String video){
        course.setVideo(video);
    }

    public void addNote(String note){
        course.setNote(note);
    }

    public void addHomework(String homework){
        course.setHomework(homework);
    }

    public Course build() {
        return course;
    }
}
