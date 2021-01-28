package com.xima.design.pattern.结构型.组合模式_Composite.s4实例_文件系统;

import java.util.ArrayList;

class Folder extends AbstractFile {
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    private ArrayList<AbstractFile> list = new ArrayList<>();

    @Override
    public void add(AbstractFile file) {
        list.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        list.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        AbstractFile file = list.get(i);
        return file;
    }

    //递归进行查杀
    @Override
    public void killVirus() {
        System.out.println("对文件夹" + name + "内进行查杀...");
        for (AbstractFile obj : list) {
            obj.killVirus();
        }
    }
}