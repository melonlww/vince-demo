package com.xima.jvm.practice.stage1_classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * 实验1.操作步骤
 * 1. mvn clean compile
 * 2. cp -r target/classes/* file/
 * 3. rm target/classes/com/xima/jvm/practice/stage1_classloader/MySample.class
 * 4. run main
 *
 * result====================
 * MyTest17_1_复杂类加载 classloader:jdk.internal.loader.ClassLoaders$AppClassLoader@ed17bee
 * class:1308927845
 * classloader:MyTest16_1_自定义类加载器{classLoaderName='loader1'}
 * MySample is loaded by:MyTest16_1_自定义类加载器{classLoaderName='loader1'}
 * MyCat is loaded by:jdk.internal.loader.ClassLoaders$AppClassLoader@ed17bee
 *
 * 删除classpath下的MySample.class
 * 结果：
 * MySample被自定义loader1加载
 * MyCat被AppClassLoader加载
 *
 *
 * 实验1.操作步骤
 * 1. mvn clean compile
 * 2. cp -r target/classes/* file/
 * 3. rm target/classes/com/xima/jvm/practice/stage1_classloader/MyCat.class
 * 4. run main
 *
 *  result====================
 * MyTest17_1_复杂类加载 classloader:jdk.internal.loader.ClassLoaders$AppClassLoader@ed17bee
 * class:2137589296
 * classloader:jdk.internal.loader.ClassLoaders$AppClassLoader@ed17bee
 * MySample is loaded by:jdk.internal.loader.ClassLoaders$AppClassLoader@ed17bee
 * Exception in thread "main" java.lang.reflect.InvocationTargetException
 * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
 * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
 * 	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
 * 	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
 * 	at com.xima.jvm.practice.stage1_classloader.MyTest17_1_复杂类加载.main(MyTest17_1_复杂类加载.java:40)
 * Caused by: java.lang.NoClassDefFoundError: com/xima/jvm/practice/stage1_classloader/MyCat
 * 	at com.xima.jvm.practice.stage1_classloader.MySample.<init>(MySample.java:8)
 * 	... 5 more
 * Caused by: java.lang.ClassNotFoundException: com.xima.jvm.practice.stage1_classloader.MyCat
 * 	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
 * 	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
 * 	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
 * 	... 6 more
 *
 * 删除classpath下的MyCat.class
 * 结果：
 * MySample被AppClassLoade加载
 * MyCat无法被加载，抛出异常
 * 原因：MySample中显示使用MyCat，此时jvm用加载MySample的类加载器AppClassLoader去加载MyCat，
 * 因为classpath下的MyCat.class已经被删除，所以AppClassLoader无法加载到MyCat类，因此抛出异常
 *
 *
 *
 *
 * 关于命名空间重要说明:
 * 1.子加载器所加载的类能够访问父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest17_1_复杂类加载与命名空间关系 extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("MyTest17_1_复杂类加载 classloader:" + MyTest17_1_复杂类加载与命名空间关系.class.getClassLoader());
        MyTest16_1_自定义类加载器_双亲委派 loader1 = new MyTest16_1_自定义类加载器_双亲委派("loader1");
        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
//        loader1.setPath("D:\\project1\\vince-practice\\jvm-practice\\file\\");
        Class<?> clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.MySample");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("classloader:" + clazz.getClassLoader());

        Object object = clazz.getDeclaredConstructor().newInstance();
    }

}
