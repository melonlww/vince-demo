package com.xima.jvm.practice.stage1_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * 1.继承ClassLoader
 * 2.将class文件（HelloWorld.class）放到file目录下
 * 3.注意: 删除原target下的HelloWorld.class删除，假设此class文件为其他程序生成，本来不应该在target目录下
 * 4 `MyTest16_1_自定义类加载器`交由父类加载器AppClassLoader加载，AppClassLoader加载不了，所以由自定义类加载器`MyTest16_1_自定义类加载器`来加载。最后自定义加载器加载成功
 *
 * result===========
 * com.xima.jvm.practice.stage1_classloader.HelloWorld@668bc3d5
 * MyTest16_1_自定义类加载器{classLoaderName='loader1'}
 */
public class MyTest16_1_自定义类加载器_双亲委派 extends ClassLoader {

    private String classLoaderName;

    private String fileExtension = ".class";

    private String path;

    public MyTest16_1_自定义类加载器_双亲委派(String classLoaderName) {
        // this(checkCreateClassLoader(), null, getSystemClassLoader());
        // 将系统类加载器（app classloader）当做该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_1_自定义类加载器_双亲委派(ClassLoader parent, String classLoaderName) {
        //this(checkCreateClassLoader(), null, parent);
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_1_自定义类加载器_双亲委派(ClassLoader classLoader) {
        super(classLoader);
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
        return "MyTest16_1_自定义类加载器{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyTest16_1_自定义类加载器_双亲委派 loader1 = new MyTest16_1_自定义类加载器_双亲委派("loader1");
        loader1.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        Class<?> clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        System.out.println(clazz.hashCode());
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());


        MyTest16_1_自定义类加载器_双亲委派 loader2 = new MyTest16_1_自定义类加载器_双亲委派("loader2");
        loader2.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        Class<?> clazz2 = loader2.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        System.out.println(clazz2.hashCode());
        Object object2 = clazz2.getDeclaredConstructor().newInstance();
        System.out.println(object2);
        System.out.println(clazz2.getClassLoader());

        MyTest16_1_自定义类加载器_双亲委派 loader3 = new MyTest16_1_自定义类加载器_双亲委派(loader2,"loader3");
        loader3.setPath("/Users/xmly/practice/code/vince-practice/jvm-practice/file/");
        Class<?> clazz3 = loader3.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        System.out.println(clazz3.hashCode());
        Object object3 = clazz3.getDeclaredConstructor().newInstance();
        System.out.println(object3);
        System.out.println(clazz3.getClassLoader());

    }


}
