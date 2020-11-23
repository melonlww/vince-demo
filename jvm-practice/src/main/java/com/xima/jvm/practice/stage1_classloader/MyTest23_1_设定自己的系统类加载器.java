package com.xima.jvm.practice.stage1_classloader;


/**
 * 操作步骤
 * 1. 进入pom.xml目录，编译
 *   mvn clean compile
 * 2. 进入classpath
 *   cd target/classes
 * 3. 在terminal中运行java
 *   java -Djava.system.class.loader=com.xima.jvm.practice.stage1_classloader.MyTest16_1_自定义类加载器_双亲委派 com.xima.jvm.practice.stage1_classloader.MyTest23_jvm内建的加载器是如何产生的
 * result==============================================
 * null
 * jdk.internal.loader.ClassLoaders$AppClassLoader@579bb367
 * jdk.internal.loader.ClassLoaders$AppClassLoader@579bb367
 * MyTest16_1_自定义类加载器{classLoaderName='null'}
 *
 *
 * 结果：系统加载类成功设置为指定的MyTest16，运行时设置系统参数：-Djava.system.class.loader=com.xima.jvm.practice.stage1_classloader.MyTest16_1_自定义类加载器_双亲委派
 *
 * 阅读ClassLoader.getSystemClassLoader()方法的javaDoc，知道可以设置系统属性java.system.class.loader指定系统加载类

 *        Returns the system class loader.  This is the default
 *      * delegation parent for new {@code ClassLoader} instances, and is
 *      * typically the class loader used to start the application.
 *      *
 *      * <p> This method is first invoked early in the runtime's startup
 *      * sequence, at which point it creates the system class loader. This
 *      * class loader will be the context class loader for the main application
 *      * thread (for example, the thread that invokes the {@code main} method of
 *      * the main class).
 *      *
 *      * <p> The default system class loader is an implementation-dependent
 *      * instance of this class.
 *      *
 *      * <p> If the system property "{@code java.system.class.loader}" is defined
 *      * when this method is first invoked then the value of that property is
 *      * taken to be the name of a class that will be returned as the system
 *      * class loader.  The class is loaded using the default system class loader
 *      * and must define a public constructor that takes a single parameter of
 *      * type {@code ClassLoader} which is used as the delegation parent.  An
 *      * instance is then created using this constructor with the default system
 *      * class loader as the parameter.  The resulting class loader is defined
 *      * to be the system class loader. During construction, the class loader
 *      * should take great care to avoid calling {@code getSystemClassLoader()}.
 *      * If circular initialization of the system class loader is detected then
 *      * an {@code IllegalStateException} is thrown.
 *
 *
 *
 *
 */
public class MyTest23_1_设定自己的系统类加载器 {

    public static void main(String[] args) {
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println(MyTest23_1_设定自己的系统类加载器.class.getClassLoader());

        System.out.println(HelloWorld.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
