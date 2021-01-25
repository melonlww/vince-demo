package com.xima.design.pattern.创建型.工厂模式_Factory.s3抽象工厂;

import com.xima.design.pattern.创建型.工厂模式_Factory.s3抽象工厂.obj.*;

//抽象工厂实现
public class AppleFactory extends AbstractFactory{

    @Override
    public InterfacePad getPad() {
        super.init();
        return new IPad();
    }

    @Override
    public InterfacePhone getPhone() {
        super.init();
        return new IPhone();
    }

    @Override
    public InterfaceWatch getWatch() {
        super.init();
        return new IWatch();
    }
}