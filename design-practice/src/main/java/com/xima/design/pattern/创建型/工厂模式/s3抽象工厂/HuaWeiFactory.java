package com.xima.design.pattern.创建型.工厂模式.s3抽象工厂;

import com.xima.design.pattern.创建型.工厂模式.s3抽象工厂.obj.*;

//抽象工厂实现
public class HuaWeiFactory extends AbstractFactory{

    @Override
    public InterfacePad getPad() {
        super.init();
        return new HuaWeiPad();
    }

    @Override
    public InterfacePhone getPhone() {
        super.init();
        return new HuaWeiPhone();
    }

    @Override
    public InterfaceWatch getWatch() {
        super.init();
        return new HuaWeiWatch();
    }
}