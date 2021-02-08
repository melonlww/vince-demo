package com.xima.design.pattern.行为型.状态模式_State.s3实例_论坛;

public class Test {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论：好文章");
    }
}
