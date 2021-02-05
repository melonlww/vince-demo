package com.xima.design.pattern.行为型.迭代器模式_Iterator.s2实例;

public interface ICourseAggregate {
    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();
}
