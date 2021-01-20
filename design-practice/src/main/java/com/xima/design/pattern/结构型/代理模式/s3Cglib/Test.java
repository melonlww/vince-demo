package com.xima.design.pattern.结构型.代理模式.s3Cglib;

import com.xima.design.pattern.结构型.代理模式.obj.RealObj;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * Cglib继承的方式，覆盖父类的方法
 * JDK Proxy采用的实现方式，必须要求代理目标对象一定要实现一个接口
 * 思想：都是通过生成字节码，重组一个新的类
 *
 * JDK Proxy对于用户而言，依赖更强，调用也更复杂
 * Cglib对目标类没有任何要求
 *
 * Cglib效率更高，性能也更高，底层没有用到反射
 * JDK Proxy 生成逻辑较为简单，执行效率要低，每次都要分射
 *
 * Cglib有个坑，目标代理类不能有final的方法，忽略final修饰的方法
 *
 *
 * Spring可以通过配置强制使用Cglib，组需要Spring配置文件中加入如下代码：
 * <aop:aspectj-autoproxy proxy-target-class="true"/>
 *
 *
 *
 */
public class Test {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/xmly/practice/code/vince-demo/design-practice/src/main/java/com/xima/design/pattern/结构型/代理模式/s3Cglib");

        CglibProxy cglibProxy = new CglibProxy();
        RealObj subject = (RealObj) cglibProxy.getInstance(RealObj.class);
        subject.request();
    }
}
