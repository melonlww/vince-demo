package com.xima.design.pattern.结构型.组合模式_Composite.s3实例_公司层级;

public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        //输出树形结构的子节点
        for(int i=0; i<depth; i++) {
            System.out.print('-');
        }
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + " : 公司财务收支管理");
    }

}