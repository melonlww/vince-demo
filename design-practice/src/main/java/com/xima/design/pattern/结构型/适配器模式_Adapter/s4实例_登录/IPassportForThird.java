package com.xima.design.pattern.结构型.适配器模式_Adapter.s4实例_登录;

public interface IPassportForThird {
    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTel(String phone, String code);
}
