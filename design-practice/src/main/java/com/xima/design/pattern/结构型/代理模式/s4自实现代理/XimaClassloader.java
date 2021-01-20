package com.xima.design.pattern.结构型.代理模式.s4自实现代理;

import com.xima.design.pattern.CommonFile;

import java.io.File;

public class XimaClassloader extends ClassLoader{

    private File classPathFile;

    public XimaClassloader(){
        String classPath = CommonFile.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = CommonFile.class.getPackage().getName() + "." + name;
        if(classPathFile!=null){

        }
        return null;
    }


}
