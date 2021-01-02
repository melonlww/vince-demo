package com.xima.springframework.ioc.practice.stage1;

import com.xima.springframework.ioc.practice.stage1.bean.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * IoC (Inverse of Control， 控制反转)
 * DI (Dependency Injection， 依赖注入)
 *
 * 关于Spring容器管理Bean的过程以及加载模式：
 * 1.需要将bean的定义信息声明在Spring的配置文件当中 （applicationContext.xml）
 * 2.需要通过Spring抽象出的各种Resource来指定对应的配置文件
 * 3.需要显示声明一个Spring工厂（defaultListableBeanFactory），该工厂用来掌控我们在配置文件中所声明的各种bean以及bean之间的依赖关系与注入关系
 * 4.需要定义一个配置信息读取器（beanDefinitionReader），该读取器用来读取之前所定义的bean配置文件信息（resource）
 * 5.读取器的作用是读取我们所声明的配置文件信息，并且将读取后的信息装配到之前所声明的工厂当中
 * 6.需要将读取器与工厂以及资源对象进行相应的关联处理 （1.读取器-->工厂 读取器-->资源  2.资源中的bean装配到工厂当中）
 * 7.工厂所管理的全部对象装配完毕，可以供客户端直接调用，获取客户端想要使用的各种bean对象。
 *
 *
 * Spring对Bean管理的核心组件：
 * 1.资源抽象
 * 2.工厂
 * 3.配置信息读取器
 *
 *
 * BeanFactory是Spring Bean工厂最顶层的抽象
 *
 *
 * 关于Spring Bean实例的注册流程
 * 1.定义好Spring的配置文件
 * --------------   applicationContext.xml
 *
 * 2.通过Resource对象将Spring配置文件进行抽象，抽象成一个具体的Resource对象（如ClassPathResource）
 * --------------   SpringClient1_Spring容器管理Bean过程 1.定义一个资源
 *
 * 3.定义好将要使用的Bean工厂（各种BeanFactory，DefaultListableBeanFactory）
 * --------------   SpringClient1_Spring容器管理Bean过程 2.定义一个工厂
 *
 * 4.定义好XmlBeanDefinitionReader对象，并将工厂对象作为参数传递进去，从而构建好二者之间的关联关系
 * --------------   SpringClient1_Spring容器管理Bean过程 3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理
 *
 * 5.通过XmlBeanDefinitionReader对象读取（loadBeanDefinitions方法）之前所抽象出的Resource对象
 * --------------   SpringClient1_Spring容器管理Bean过程 4.定义好从指定资源中读取
 *
 * 6.流程开始进行解析
 * --------------   SpringClient1_Spring容器管理Bean过程   loadBeanDefinitions
 *
 * 7.针对XML文件进行各种元素以及元素属性的计息，这里面，真正的解析是通过BeanDefinitionParserDelegate对象来完成的 （委托模式）
 * --------------   DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions(Element root) --> parseBeanDefinitions(root, this.delegate);
 *
 * 8.通过BeanDefinitionParserDelegate对象在解析XML文件时，又使用到了模板方法设计模式（pre，parse，post）
 * --------------   DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions(Element root)  --> preProcessXml(root); parseBeanDefinitions(root, this.delegate); postProcessXml(root);
 *
 * 9.当所有的bean标签元素都解析完毕后，开始定义一个BeanDefinition对象，该对象是一个非常重要的对象，里面容纳了一个Bean相关的所有属性
 * --------------   BeanDefinitionParserDelegate#parseBeanDefinitionElement(Element ele, String beanName, @Nullable BeanDefinition containingBean)  --> AbstractBeanDefinition bd = createBeanDefinition(className, parent);
 *
 * 10.BeanDefinition对象创建完毕后，Spring又会创建BeanDefinitionHolder对象来持有这个BeanDefinition对象
 * --------------   BeanDefinitionParserDelegate#parseBeanDefinitionElement(Element ele, String beanName, @Nullable BeanDefinition containingBean)   --> return new BeanDefinitionHolder(beanDefinition, beanName, aliasesArray);
 *
 * 11.BeanDefinitionHolder对象主要包含两个部分：beanName与BeanDefinition
 * --------------   BeanDefinitionHolder
 *
 * 12.工厂会将解析出来的Bean信息存放到内部一个ConcurrentHashMap中，该Map的建是beanName(唯一)，值是BeanDefinition对象
 * --------------   DefaultListableBeanFactory#registerBeanDefinition(String beanName, BeanDefinition beanDefinition) --> this.beanDefinitionMap.put(beanName, beanDefinition);
 *
 * 13.调用Bean解析完毕的触发动作，从而触发相应的监听器的方法执行（使用到了观察者模式）
 * --------------   DefaultBeanDefinitionDocumentReader#processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate)  --> getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));
 *
 */
public class SpringClient1_Spring容器管理Bean过程 {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 工厂装配完毕， 获取bean对象
        Student student = (Student) defaultListableBeanFactory.getBean("student");
        System.out.println(student);
    }
}
