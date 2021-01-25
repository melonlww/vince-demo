package com.xima.design.pattern.结构型.代理模式_Proxy.s4自实现代理;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import com.xima.design.pattern.CommonFile;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class XimaProxy {

    private final static String LN = "\r\n";

    private final static String PROXY_CLASS_NAME = "$Proxy0";

    public static Object newProxyInstance(XimaClassloader loader,
                                          Class<?>[] interfaces,
                                          XimaInvocationHandler h) {
        //1.动态生成源码.java文件
        String src = generateSrc(interfaces);
//        System.out.println(src);
        //2.Java文件输出到磁盘，保存为文件$Proxy0.java
        File f = saveFile(src);

        //3.把.java文件编译成$Proxy0.class文件
        compilerSrc(f);

        //4.把生成的.class文件加载到JVM中
        Object obj = loadClass(loader, h);
        //5.返回新的代理对象
        f.delete();
        return obj;
    }

    private static Object loadClass(XimaClassloader loader, XimaInvocationHandler h) {
        Object obj = null;
        try {
            Class proxyClass = loader.findClass(PROXY_CLASS_NAME);
            Constructor c = proxyClass.getDeclaredConstructor(XimaInvocationHandler.class);
            obj = c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    private static void compilerSrc(File f) {
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.xima.design.pattern;" + LN);
        sb.append("import com.xima.design.pattern.结构型.代理模式.s4自实现代理.XimaInvocationHandler;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        for (Class<?> iterf : interfaces) {
            sb.append("import " + iterf.getName() + ";" + LN);
        }

        sb.append("public class " + PROXY_CLASS_NAME + " implements");
        for (Class<?> iterf : interfaces) {
            String[] iterfPackageName = iterf.getName().replace(".", ",").split(",");
            sb.append(" " + iterfPackageName[iterfPackageName.length - 1]);
        }
        sb.append("{" + LN);
        sb.append("private XimaInvocationHandler h;" + LN);
        sb.append("public " + PROXY_CLASS_NAME + "(XimaInvocationHandler h){" + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);

        for (Class<?> iterf : interfaces) {
            for (Method method : iterf.getDeclaredMethods()) {
                sb.append("@Override" + LN);
                sb.append("public " + method.getReturnType() + " " + method.getName() + "(");

                    StringBuilder methodParamSb = new StringBuilder();
                    int varParamNum = 0;
                    for (Class<?> parameterType : method.getParameterTypes()) {
                        methodParamSb.append(parameterType.getName() + " " + "var" + (varParamNum++) + ",");
                    }
                    String methodParamStr = methodParamSb.toString();
                    if (methodParamStr.length() > 0) {
                        methodParamStr = methodParamStr.substring(0, methodParamStr.length() - 1);
                    }
                    sb.append(methodParamStr + "){" + LN);


                sb.append("try{" + LN);
//
                sb.append("Method m = " + iterf.getName() + ".class.getMethod(\"" + method.getName() + "\"");
                sb.append(", new Class[]{");
                    StringBuilder methodParamClassSb = new StringBuilder();
                    for (Class<?> parameterType : method.getParameterTypes()) {
                        methodParamClassSb.append(parameterType.getName() + ".class,");
                    }
                    String methodParamClassStr = methodParamClassSb.toString();
                    if (methodParamClassStr.length() > 0) {
                        methodParamClassStr = methodParamClassStr.substring(0, methodParamClassStr.length() - 1);
                    }
                    sb.append(methodParamClassStr + "});" + LN);

                sb.append("this.h.invoke(this, m, new Object[]{");
                        StringBuilder methodParamValueSb = new StringBuilder();
                        int varValueNum = 0;
                        for (Class<?> parameterType : method.getParameterTypes()) {
                            methodParamValueSb.append("var" + (varValueNum++) + ",");
                        }
                        String methodParamValueStr = methodParamValueSb.toString();
                        if (methodParamValueStr.length() > 0) {
                            methodParamValueStr = methodParamValueStr.substring(0, methodParamValueStr.length() - 1);
                        }
                        sb.append(methodParamValueStr + "});" + LN);
                sb.append("}catch (Error _ex){" + LN);
                sb.append("}catch (Throwable throwable){ " + LN);
                sb.append("throw new UndeclaredThrowableException(throwable);" + LN);
                sb.append("}" + LN);
                sb.append("}" + LN);
            }
        }
        sb.append("}" + LN);
        return sb.toString();
    }

    private static File saveFile(String src) {
        String filePath = CommonFile.class.getResource("").getPath();
        File f = null;
        try {
            f = new File(filePath + PROXY_CLASS_NAME + ".java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(generateSrc(com.xima.design.pattern.结构型.代理模式_Proxy.obj.RealSubject.class.getInterfaces()));
    }
}

/**
 * 生成字符串
 * ======================================
 * package com.xima.design.pattern;
 * import com.xima.design.pattern.结构型.代理模式.s4自实现代理.XimaInvocationHandler;
 * import java.lang.reflect.*;
 * import com.xima.design.pattern.结构型.代理模式.obj.ISubject;
 * public class $Proxy0 implements ISubject{
 * private XimaInvocationHandler h;
 * public $Proxy0(XimaInvocationHandler h){
 * this.h = h;
 * }
 * @Override
 * public void request(){
 * try{
 * Method m = com.xima.design.pattern.结构型.代理模式.obj.ISubject.class.getMethod("request", new Class[]{});
 * this.h.invoke(this, m, new Object[]{});
 * }catch (Error _ex){
 * }catch (Throwable throwable){
 * throw new UndeclaredThrowableException(throwable);
 * }
 * }
 * @Override
 * public void showName(java.lang.String var0){
 * try{
 * Method m = com.xima.design.pattern.结构型.代理模式.obj.ISubject.class.getMethod("showName", new Class[]{java.lang.String.class});
 * this.h.invoke(this, m, new Object[]{var0});
 * }catch (Error _ex){
 * }catch (Throwable throwable){
 * throw new UndeclaredThrowableException(throwable);
 * }
 * }
 * }
 */

