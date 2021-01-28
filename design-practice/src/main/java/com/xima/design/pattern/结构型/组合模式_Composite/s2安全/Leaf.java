package com.xima.design.pattern.结构型.组合模式_Composite.s2安全;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
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