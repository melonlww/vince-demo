package com.xima.design.pattern.结构型.代理模式.s4自实现代理;

public class XimaProxy {

    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          XimaInvocationHandler h){
        //1.动态生成源码.java文件

        //2.Java文件输出到磁盘，保存为文件$Proxy0.java

        //3.把.java文件编译成$Proxy0.class文件

        //4.把生成的.class文件加载到JVM中

        //5.返回新的代理对象

        return null;
    }
}

