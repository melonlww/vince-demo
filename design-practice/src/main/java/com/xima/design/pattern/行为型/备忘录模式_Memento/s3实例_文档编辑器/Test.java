package com.xima.design.pattern.行为型.备忘录模式_Memento.s3实例_文档编辑器;

public class Test {
    public static void main(String[] args) {
        DraftBox draftBox = new DraftBox();

        Editor editor = new Editor("东方新闻", "两市第三只千元股诞生 爱美客股价突破1000元", "3553a1a.png");
        ArticleMemento articleMemento = editor.saveToMemento();
        draftBox.addMemento(articleMemento);
        System.out.println("完整信息：" + editor);
        System.out.println("暂存成功");

        System.out.println("================首次修改文章================");
        editor.setTitle("「头条」东方新闻");
        editor.setContent("两市第3000元股诞生 爱美客股价突破10，000，000元");
        System.out.println("完整信息：" + editor);
        System.out.println("================首次修改文章================");
        //保存
        articleMemento = editor.saveToMemento();
        draftBox.addMemento(articleMemento);


        System.out.println("================第2次修改文章================");
        editor.setTitle("「头条推荐」东方新闻");
        System.out.println("完整信息：" + editor);
        System.out.println("================第2次修改文章================");
        //没有保存

        System.out.println("================第1次回退================");
        articleMemento = draftBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息：" + editor);
        System.out.println("================第1次回退================");

        System.out.println("================第2次回退================");
        articleMemento = draftBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息：" + editor);
        System.out.println("================第2次回退================");

    }
}
