package com.xima.design.pattern.结构型.组合模式_Composite.s4实例_文件系统;

abstract class AbstractFile {
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}