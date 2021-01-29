package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters;


import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;

public interface ILoginAdapter {

    boolean support(Object object);

    ResultMsg login(String id, Object adapter);
}
