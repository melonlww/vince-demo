package com.xima.jvm.practice.stage1_classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文加载器的一般使用模式（获取-使用-还原）
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try{
 * Thread.currentThread().setContextClassLoader(targetClassLoader);
 * myMethod();
 * } finally{
 * Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。
 * <p>
 * 如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
 * <p>
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制。
 * <p>
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程上下文类加载器来帮助高层的ClassLoader
 * 找到并加载该类
 *
 *
 * {@link ServiceLoader} java Doc 摘要：
 *  * A service provider that is packaged as a JAR file for the class path is
 *  * identified by placing a <i>provider-configuration file</i> in the resource
 *  * directory {@code META-INF/services}. The name of the provider-configuration
 *  * file is the fully qualified binary name of the service. The provider-configuration
 *  * file contains a list of fully qualified binary names of service providers, one
 *  * per line.
 *  *
 *  * <p> For example, suppose the service provider
 *  * {@code com.example.impl.StandardCodecs} is packaged in a JAR file for the
 *  * class path. The JAR file will contain a provider-configuration file named:
 *  *
 *  * <blockquote>{@code
 *  *     META-INF/services/com.example.CodecFactory
 *  * }</blockquote>
 *  *
 *  * that contains the line:
 *  *
 *  * <blockquote>{@code
 *  *     com.example.impl.StandardCodecs # Standard codecs
 *  * }</blockquote>
 *
 *
 *
 * 举例： mysql驱动的实现就是通过SPI
 * mysql-connector-java:5.1.45.jar包中
 * META-INF/services/java.sql.Driver
 *
 * com.mysql.jdbc.Driver
 * com.mysql.fabric.jdbc.FabricMySQLDriver
 *
 *
 *
 *
 *
 *
 * 实验一：
 * 1.maven加入mysql依赖
 *     <dependency>
 *       <groupId>mysql</groupId>
 *       <artifactId>mysql-connector-java</artifactId>
 *       <version>5.1.45</version>
 *     </dependency>
 * 2.run main
 *
 * result=======================
 * driver:class com.mysql.jdbc.Driver, loader:jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 * driver:class com.mysql.fabric.jdbc.FabricMySQLDriver, loader:jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 * 当前线程上下文类加载器：jdk.internal.loader.ClassLoaders$AppClassLoader@2c13da15
 * ServiceLoader的类加载器：null
 *
 * 实验二：
 * 1.加上 Thread.currentThread().setContextClassLoader(MyTest26_通过SPI_ServiceLoader加载MySQL实现的Driver接口的驱动类.class.getClassLoader().getParent());
 * 2 run main
 * result========================
 * 当前线程上下文类加载器：jdk.internal.loader.ClassLoaders$PlatformClassLoader@5d624da6
 * ServiceLoader的类加载器：null
 *
 * ServiceLoader用当前ContextClassLoader->ExtClassLoader/PlatformClassLoader去加载mysql的驱动类，
 * 显然加载不到，所以没有打印出driver信息
 *
 *
 *
 *
 */
public class MyTest26_通过SPI_ServiceLoader加载MySQL实现的Driver接口的驱动类 {

    public static void main(String[] args) {
        //实验二：
//        Thread.currentThread().setContextClassLoader(MyTest26_通过SPI_ServiceLoader加载MySQL实现的Driver接口的驱动类.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ", loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器："+ Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }
}
