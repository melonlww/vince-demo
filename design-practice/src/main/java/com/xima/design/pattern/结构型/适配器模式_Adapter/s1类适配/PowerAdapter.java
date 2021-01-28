package com.xima.design.pattern.结构型.适配器模式_Adapter.s1类适配;

import com.xima.design.pattern.结构型.适配器模式_Adapter.AC220;

public class PowerAdapter extends AC220 implements DC5 {

    @Override
    public int output5V() {
        int adapterInput = super.outputAC220();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}
