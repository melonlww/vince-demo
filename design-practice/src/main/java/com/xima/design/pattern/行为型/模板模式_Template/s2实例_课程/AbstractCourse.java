package com.xima.design.pattern.行为型.模板模式_Template.s2实例_课程;

public abstract class AbstractCourse {

    protected final void createCourse(){
        //1.发布预习资料
        postPreResource();
        //2.制作课件
        createPPT();
        //3.直播授课
        liveVideo();
        //4.上传课后资料
        postResource();
        //5.检查课后作业
        if(needCheckHomework()){
            checkHomework();
        }
    }

    protected abstract boolean needCheckHomework();

    protected void postPreResource() {
        System.out.println("发布预习资料");
    }

    protected void createPPT() {
        System.out.println("制作课件");
    }

    protected void liveVideo() {
        System.out.println("直播授课");
    }

    protected void postResource() {
        System.out.println("上传课后资料");
    }

    protected void checkHomework() {
        System.out.println("检查课后作业");
    }
}
