package com.xima.design.pattern.行为型.迭代器模式_Iterator.s2实例;

import java.util.List;

public class IteratorImpl<E> implements Iterator<E> {
    private List<E> list;
    private int cursor;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置 " + cursor + ":");
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        if (cursor > list.size() - 1) {
            return false;
        }
        return true;
    }
}
