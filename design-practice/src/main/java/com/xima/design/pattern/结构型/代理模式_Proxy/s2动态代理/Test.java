package com.xima.design.pattern.结构型.代理模式_Proxy.s2动态代理;

import com.xima.design.pattern.结构型.代理模式_Proxy.obj.ISubject;
import com.xima.design.pattern.结构型.代理模式_Proxy.obj.RealSubject;
//import sun.misc.ProxyGenerator;


public class Test {

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        ISubject subject = (ISubject)jdkProxy.getInstance(new RealSubject());
        subject.request();

        /*byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{ISubject.class});
        try{
            FileOutputStream os = new FileOutputStream("/Users/xmly/practice/code/vince-demo/design-practice/src/main/java/com/xima/design/pattern/结构型/代理模式/s2动态代理/$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
