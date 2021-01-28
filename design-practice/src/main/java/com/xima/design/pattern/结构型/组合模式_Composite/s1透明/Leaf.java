package com.xima.design.pattern.结构型.组合模式_Composite.s1透明;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Override
    public void display(int depth) {
        //输出树形结构的叶子节点
        for (int i = 0; i < depth; i++) {
            System.out.print('-');
        }
        System.out.println(name);
    }

}