package com.xima.jvm.practice.stage3_memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * -XX:MaxMetaspaceSize=10m
 *
 *
 *
 * hello world
 * hello world
 * hello world
 * Exception in thread "main" net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
 * 	at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:345)
 * 	at net.sf.cglib.proxy.Enhancer.generate(Enhancer.java:492)
 * 	at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:114)
 * 	at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:291)
 * 	at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
 * 	at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:305)
 * 	at com.xima.jvm.practice.stage3_memory.MyTest4_方法区产生溢出_使用Cglib.main(MyTest4_方法区产生溢出_使用Cglib.java:18)
 * Caused by: java.lang.reflect.InvocationTargetException
 * 	at java.base/jdk.internal.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
 * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
 * 	at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:459)
 * 	at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:336)
 * 	... 6 more
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 * 	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
 * 	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1016)
 * 	... 11 more
 */
public class MyTest4_方法区产生溢出_使用Cglib {

    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4_方法区产生溢出_使用Cglib.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            System.out.println("hello world");
            enhancer.create();
        }

    }
}
