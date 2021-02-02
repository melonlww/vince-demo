package com.xima.design.pattern.行为型.模板模式_Template.s2实例_课程;

public class JavaCourse extends AbstractCourse {

    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }
}
