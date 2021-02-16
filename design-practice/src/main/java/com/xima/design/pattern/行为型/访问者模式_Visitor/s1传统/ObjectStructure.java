package com.xima.design.pattern.行为型.访问者模式_Visitor.s1传统;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {

    private List<Element> elements = new LinkedList<>();

    public void attach(Element element) {
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

}