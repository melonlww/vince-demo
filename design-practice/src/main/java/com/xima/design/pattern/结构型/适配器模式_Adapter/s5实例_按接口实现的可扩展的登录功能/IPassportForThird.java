package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能;


import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTel(String phone, String code);
}
