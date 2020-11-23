package com.xima.jvm.practice.stage2_bytecode.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {

    public static void main(String[] args) {
        //jdk1.8
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles" , "true");


        Hello hello = new HelloImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),myInvocationHandler);
        proxyHello.sayHello();

        System.out.println(proxyHello.getClass());
        System.out.println(proxyHello.getClass().getSuperclass());
        System.out.println(proxyHello.getClass().getInterfaces()[0]);
    }

}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("hello vince");
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("this is proxy");
        return method.invoke(target,args);
    }
}