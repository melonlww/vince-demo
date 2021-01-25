package com.xima.design.pattern.结构型.代理模式_Proxy.s4自实现代理;

import com.xima.design.pattern.CommonFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class XimaClassloader extends ClassLoader {

    private File classPathFile;

    public XimaClassloader() {
        String classPath = CommonFile.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = CommonFile.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replace(".", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
