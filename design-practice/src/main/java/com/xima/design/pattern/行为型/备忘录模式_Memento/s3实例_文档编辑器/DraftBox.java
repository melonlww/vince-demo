package com.xima.design.pattern.行为型.备忘录模式_Memento.s3实例_文档编辑器;

import java.util.Stack;

/**
 * 草稿箱
 */
public class DraftBox {
    private final Stack<ArticleMemento> STACK = new Stack<>();

    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }
}
