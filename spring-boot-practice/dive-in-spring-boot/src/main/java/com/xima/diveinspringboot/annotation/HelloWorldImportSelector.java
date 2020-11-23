package com.xima.diveinspringboot.annotation;

import com.xima.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link ImportSelector}实现
 */
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * 返回bean名称
         */
        return new String[]{
            HelloWorldConfiguration.class.getName()};
    }
}
