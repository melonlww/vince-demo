package org.geekbang.ioc.java.beans;

import org.geekbang.ioc.java.beans.pojo.Person;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * {@link BeanInfo}
 */
public class d2_javaBean自省_类型转换 {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Person person = new Person();

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getPropertyType();String propertyName = propertyDescriptor.getName();
                    //为age字段/属性增加 PropertyEditor
                    if ("age".equals(propertyName)) {
                        //String->Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(person);

                        Method setAgeMethod = propertyDescriptor.getWriteMethod();
                        propertyEditor.addPropertyChangeListener(new SetPropertyChangeListener(person, setAgeMethod));
                        propertyEditor.setAsText("99");
                    }
                });

        System.out.println(person);
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

    static class SetPropertyChangeListener implements PropertyChangeListener {

        private Object bean;
        private Method setWriteMethod;

        public SetPropertyChangeListener(Object bean, Method setWriteMethod) {
            this.bean = bean;
            this.setWriteMethod = setWriteMethod;
        }

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            PropertyEditor source = (PropertyEditor) event.getSource();
            try {
                setWriteMethod.invoke(bean, source.getValue());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
