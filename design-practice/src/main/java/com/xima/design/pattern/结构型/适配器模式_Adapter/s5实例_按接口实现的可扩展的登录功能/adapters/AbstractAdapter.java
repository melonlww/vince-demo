package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters;

import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;
import com.xima.design.pattern.结构型.适配器模式_Adapter.目标方法.PassportService;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {

    protected ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}
