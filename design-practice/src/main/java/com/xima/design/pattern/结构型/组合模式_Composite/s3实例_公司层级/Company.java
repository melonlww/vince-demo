package com.xima.design.pattern.结构型.组合模式_Composite.s3实例_公司层级;

public abstract class Company {

    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);

    public abstract void remove(Company company);

    public abstract void display(int depth);

    public abstract void lineOfDuty();

}
