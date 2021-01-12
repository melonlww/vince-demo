package com.xima.design.pattern.工厂模式.s3抽象工厂;

import com.xima.design.pattern.工厂模式.s3抽象工厂.obj.InterfacePad;
import com.xima.design.pattern.工厂模式.s3抽象工厂.obj.InterfacePhone;
import com.xima.design.pattern.工厂模式.s3抽象工厂.obj.InterfaceWatch;

//抽象工厂
public abstract class AbstractFactory {

    protected void init(){
        System.out.println("抽象工厂");
    }

    public abstract InterfacePad getPad();

    public abstract InterfacePhone getPhone();

    public abstract InterfaceWatch getWatch();
}