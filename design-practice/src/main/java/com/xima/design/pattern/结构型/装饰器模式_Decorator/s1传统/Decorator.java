package com.xima.design.pattern.结构型.装饰器模式_Decorator.s1传统;

public abstract class Decorator extends Component {

    protected Component component;

    public Decorator(Component component){
        this.component = component;
    }

    public void operation(){
        component.operation();
    }
}
