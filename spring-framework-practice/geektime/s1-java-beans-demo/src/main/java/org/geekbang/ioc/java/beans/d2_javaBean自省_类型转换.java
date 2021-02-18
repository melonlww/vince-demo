package org.geekbang.ioc.java.beans;

import org.geekbang.ioc.java.beans.pojo.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link BeanInfo}
 */
public class d2_javaBean自省_类型转换 {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    //为age字段/属性增加 PropertyEditor
                    if ("age".equals(propertyName)) {
                        //String->Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);

                    }
                });

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
