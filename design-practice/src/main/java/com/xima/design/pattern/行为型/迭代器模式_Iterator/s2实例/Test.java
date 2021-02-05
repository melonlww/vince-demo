package com.xima.design.pattern.行为型.迭代器模式_Iterator.s2实例;

public class Test {
    public static void main(String[] args) {
        Course java = new Course("Java架构");
        Course javaBase = new Course("Java基础");
        Course design = new Course("Java基础");
        Course ai = new Course("人工智能");

        ICourseAggregate aggregate = new CourseAggregateImpl();
        aggregate.add(java);
        aggregate.add(javaBase);
        aggregate.add(design);
        aggregate.add(ai);

        System.out.println("============课程列表===============");
        printCourse(aggregate);

        aggregate.remove(javaBase);
        aggregate.remove(ai);

        System.out.println("============课程列表===============");
        printCourse(aggregate);
    }

    private static void printCourse(ICourseAggregate aggregate) {
        Iterator iterator = aggregate.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
