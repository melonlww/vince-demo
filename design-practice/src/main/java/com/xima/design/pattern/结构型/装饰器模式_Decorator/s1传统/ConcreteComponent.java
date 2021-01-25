package com.xima.design.pattern.结构型.装饰器模式_Decorator.s1传统;

public class ConcreteComponent extends Component{

    @Override
    public void operation() {
        System.out.println("原生功能");
    }
}
