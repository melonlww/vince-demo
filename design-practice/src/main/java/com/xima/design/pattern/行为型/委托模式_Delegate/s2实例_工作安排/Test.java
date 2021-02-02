package com.xima.design.pattern.行为型.委托模式_Delegate.s2实例_工作安排;

public class Test {

    public static void main(String[] args) {
        Leader leader = new Leader();
        new Boss().command("爬虫", leader);
        new Boss().command("海报图", leader);
    }
}
