package com.xima.design.pattern.行为型.中介者模式_Mediator.s1传统;

import java.util.ArrayList;
import java.util.List;

/***
 * 中介者实现类
 */
public class ConcreteMediator extends Mediator {

    /**
     * 被中介者代理的同事
     */
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleague.setMediator(this);
            this.colleagues.add(colleague);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        colleagues.forEach(c -> {
            if (!c.equals(colleague)) {
                c.receive();
            }
        });
    }
}

