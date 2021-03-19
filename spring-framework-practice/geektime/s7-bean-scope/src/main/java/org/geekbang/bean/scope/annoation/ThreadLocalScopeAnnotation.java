package org.geekbang.bean.scope.annoation;

import org.geekbang.bean.scope.ThreadLocalScope;
import org.springframework.context.annotation.Scope;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(ThreadLocalScope.SCOPE_NAME) //自定义thread-local scope
public @interface ThreadLocalScopeAnnotation {
}
