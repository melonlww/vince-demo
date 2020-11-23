package com.xima.jvm.practice.stage1_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * 1.继承ClassLoader
 * 2.根据ClassLoader java Doc中例子，重写findClass
 * class NetworkClassLoader extends ClassLoader {
 *            String host;
 *            int port;
 *
 *            public Class findClass(String name) {
 *                byte[] b = loadClassData(name);
 *                return defineClass(name, b, 0, b.length);
 *            }
 *
 *            private byte[] loadClassData(String name) {
 *                // load the class data from the connection
 *                 . . .
 *            }
 *        }
 *
 * 3. com.xima.jvm.practice.stage1_classloader.HelloWorld符合App ClassLoader加载规则，
 *  所以会被App ClassLoader加载，因此不会走到我们自定义类加载器 `MyTest16_自定义类加载器_重写loadClass`
 *  so，我们重写loadClas方法，让我们自定义的类加载器直接加载HelloWorld类，不让双亲类加载器加载
 *  这样就使得我们自定义的类加载器`MyTest16_自定义类加载器_重写loadClass`加载了HelloWorld类
 *
 * loadClass方法实现步骤：
 *  1. Invoke {@link #findLoadedClass(String)} to check if the class
 *      has already been loaded.
 *      是否已经加载
 *  2. Invoke the {@link #loadClass(String) loadClass} method
 *      on the parent class loader.  If the parent is {@code null} the class
 *      loader built into the virtual machine is used, instead.
 *      给父类加载器
 *  3. Invoke the {@link #findClass(String)} method to find the class.
 *      调用findClass去寻找类
 *
 *  If the class was found using the above steps, and the
 *      * {@code resolve} flag is true, this method will then invoke the {@link
 *      * #resolveClass(Class)} method on the resulting {@code Class} object.
 *      如果找到了，调用解析类方法resolveClass
 *  Subclasses of {@code ClassLoader} are encouraged to override {@link
 *      * #findClass(String)}, rather than this method.
 *      ClassLoader的子类鼓励重写findClass方法
 *  Unless overridden, this method synchronizes on the result of
 *      * {@link #getClassLoadingLock getClassLoadingLock} method
 *      * during the entire class loading process.
 *      确保同步，保证这个类只会被加载一次
 *
 * result==========================
 * com.xima.jvm.practice.stage1_classloader.HelloWorld@2c6a3f77
 * MyTest16{classLoaderName='loader1'}
 */
public class MyTest16_自定义类加载器_重写loadClass extends ClassLoader {

    private String classLoaderName;

    private String fileExtension = ".class";

    public MyTest16_自定义类加载器_重写loadClass(String classLoaderName) {
        // this(checkCreateClassLoader(), null, getSystemClassLoader());
        // 将系统类加载器（app classloader）当做该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_自定义类加载器_重写loadClass(ClassLoader parent, String classLoaderName) {
        //this(checkCreateClassLoader(), null, parent);
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

//    protected MyTest16_自定义类加载器_重写loadClass(String name, ClassLoader parent) {
//        super(name, parent);
//    }

    protected MyTest16_自定义类加载器_重写loadClass(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        /**
         * 让com.xima.jvm.practice.stage1_classloader包开头的类由此自定义类加载器实现，
         *  其他类（例如Object）交由系统类加载器处理
         */
        if(name.startsWith("com.xima.jvm.practice.stage1_classloader")) {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    c = findClass(name);
                }
                return c;
            }
        }else{
            return super.loadClass(name);
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String className) {
        String pathName = className.replace(".", "/");
        File file = new File(this.getClass().getResource("/").getPath() + pathName + fileExtension);
//        File file = new File("/Users/xmly/practice/code/vince-practice/jvm-practice/target/classes/com/xima/jvm/practice/stage1_classloader/HelloWorld.class");
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
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyTest16_自定义类加载器_重写loadClass loader1 = new MyTest16_自定义类加载器_重写loadClass("loader1");
        Class<?> clazz = loader1.loadClass("com.xima.jvm.practice.stage1_classloader.HelloWorld");
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());
    }



}
