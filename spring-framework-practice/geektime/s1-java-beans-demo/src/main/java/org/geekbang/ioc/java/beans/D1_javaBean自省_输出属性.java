package org.geekbang.ioc.java.beans;

import org.geekbang.ioc.java.beans.pojo.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo}
 *
 * 注意输出的 property readMethod writeMethod
 *
 * ======================输出======================
 * java.beans.PropertyDescriptor[name=age; values={expert=false; visualUpdate=false; hidden=false; enumerationValues=[Ljava.lang.Object;@2b98378d; required=false}; propertyType=int; readMethod=public int org.geekbang.ioc.java.beans.pojo.Person.getAge(); writeMethod=public void org.geekbang.ioc.java.beans.pojo.Person.setAge(int)]
 * java.beans.PropertyDescriptor[name=class; values={expert=false; visualUpdate=false; hidden=false; enumerationValues=[Ljava.lang.Object;@475530b9; required=false}; propertyType=class java.lang.Class; readMethod=public final native java.lang.Class java.lang.Object.getClass()]
 * java.beans.PropertyDescriptor[name=name; values={expert=false; visualUpdate=false; hidden=false; enumerationValues=[Ljava.lang.Object;@1d057a39; required=false}; propertyType=class java.lang.String; readMethod=public java.lang.String org.geekbang.ioc.java.beans.pojo.Person.getName(); writeMethod=public void org.geekbang.ioc.java.beans.pojo.Person.setName(java.lang.String)]
 *
 */
public class D1_javaBean自省_输出属性 {

    public static void main(String[] args) throws IntrospectionException {
        //java bean自省方法 Introspector
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor ->
                        System.out.println(propertyDescriptor));
    }
}
