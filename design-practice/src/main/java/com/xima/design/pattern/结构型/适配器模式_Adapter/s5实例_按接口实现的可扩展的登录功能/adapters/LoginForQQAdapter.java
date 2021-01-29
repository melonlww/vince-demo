package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters;

import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;

public class LoginForQQAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegister(id, null);
    }
}
