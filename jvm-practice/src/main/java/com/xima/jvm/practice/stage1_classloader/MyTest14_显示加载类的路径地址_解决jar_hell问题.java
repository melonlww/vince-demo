package com.xima.jvm.practice.stage1_classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 当一个类或者一个资源文件存在多个jar中，就会存在jar hell问题
 * 可以通过以下代码来诊断问题
 */
public class MyTest14_显示加载类的路径地址_解决jar_hell问题 {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        String resourceName = "com/xima/jvm/practice/stage1_classloader/MyTest13_展示类加载器的继承关系.class";
        String resourceName = "java/lang/String.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("-----------------");
        Class<?> clazz = MyTest14_显示加载类的路径地址_解决jar_hell问题.class;
        System.out.println(clazz.getClassLoader());
    }


}
