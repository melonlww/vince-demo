package org.geekbang.bean.scope;

import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 在上下文中将RefreshScope定义成一个bean， 这个bean会注册到应用上下文中
 *
 * {@link RefreshAutoConfiguration}
 * 代码实现：{@link org.springframework.cloud.context.scope.refresh.RefreshScope}
 * 
 * @Bean
 * @ConditionalOnMissingBean(RefreshScope.class)
 *    public static RefreshScope refreshScope() {
 * 		return new RefreshScope();
 *    }
 *
 */
@RefreshScope
public class D9_RefreshScope {
}
