package com.xima.jvm.practice.stage1_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * result ==============
 * [0.002s][warning][arguments] -XX:+TraceClassUnloading is deprecated. Will use -Xlog:class+unload=info instead.
 * 940553268
 * com.xima.jvm.practice.stage1_classloader.HelloWorld@668bc3d5
 * MyTest16_2_自定义类加载器{classLoaderName='loader1'}
 * [0.355s][info   ][class,unload] unloading class com.xima.jvm.practice.stage1_classloader.HelloWorld 0x000000080009c840
 * 403424356
 * com.xima.jvm.practice.stage1_classloader.HelloWorld@1324409e
 * MyTest16_2_自定义类加载器{classLoaderName='loader1'}
 *
 *
 *
 *  类被卸载的log：
 *   [0.355s][info   ][class,unload] unloading class com.xima.jvm.practice.stage1_classloader.HelloWorld 0x000000080009c840
 *
 *  注意：如果类loader1加载器加载则类可以被卸载，会输出类卸载log信息
 *  如果类被appClassLoader加载，该类不会被卸载
 *
 *  因为：
 *  + 由Java虚拟机自带的类，在虚拟机的生命周期中，始终不会被卸载，Java虚拟机自带的类包括根类加载器，扩展类加载器和系统类加载器。Java虚拟机本身会始终应用这些加载类，而这些类加载器则会始终引用它们所加载类的Class对象，因此这些Class对象始终是可触及的
 *  + `由用户自定义的类加载器所加载的类是可以被卸载的`
 */
public class MyTest16_2_类的卸载 extends ClassLoader {

    private String classLoaderName;

    private String fileExtension = ".clazz";

    private String path;

    public MyTest16_2_类的卸载(String classLoaderName) {
        // this(checkCreateClassLoader(), null, getSystemClassLoader());
        // 将系统类加载器（app classloader）当做该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_2_类的卸载(ClassLoader parent, String classLoaderName) {
        //this(checkCreateClassLoader(), null, parent);
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String className) {
        String pathName = className.replace(".", "/");

        File file = new File(path + pathName + fileExtension);
        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            return baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new byte[0];
    }


    @Override
    public String toString() {
        return "MyTest16_2_自定义类加载器{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyTest16_2_类的卸载 loader1 = new MyTest16_2_类的卸载("loader1");
        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        Class<?> clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        System.out.println(clazz.hashCode());
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());


        object = null;
        clazz =null;
        loader1 = null;
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loader1 = new MyTest16_2_类的卸载("loader1");
        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        System.out.println(clazz.hashCode());
        object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());

    }


}
