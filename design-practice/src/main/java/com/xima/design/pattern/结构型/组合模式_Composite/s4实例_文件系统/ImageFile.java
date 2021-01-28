package com.xima.design.pattern.结构型.组合模式_Composite.s4实例_文件系统;

class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("不支持此方法...");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("不支持此方法...");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("不支持此方法...");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("对图片文件" + name + "进行查杀中...");
    }
}