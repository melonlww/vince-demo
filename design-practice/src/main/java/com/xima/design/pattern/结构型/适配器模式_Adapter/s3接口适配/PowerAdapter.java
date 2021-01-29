package com.xima.design.pattern.结构型.适配器模式_Adapter.s3接口适配;

import com.xima.design.pattern.结构型.适配器模式_Adapter.目标方法.AC220;

public class PowerAdapter implements DC {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }

    @Override
    public int output12V() {
        int adapterInput = ac220.outputAC220();
        int adapterOutput = adapterInput / 18;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }

    @Override
    public int output24V() {
        int adapterInput = ac220.outputAC220();
        int adapterOutput = adapterInput / 9;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}
