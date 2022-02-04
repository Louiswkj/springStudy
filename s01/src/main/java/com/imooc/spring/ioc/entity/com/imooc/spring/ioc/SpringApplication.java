package com.imooc.spring.ioc.entity.com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Apple;
import com.imooc.spring.ioc.entity.Child;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/21
 */
public class SpringApplication {
    public static void main(String[] args) {

        // 配置多个
        String[] configLocations = new String[]{
                "applicationContext.xml",
                "applicationContext-1.xml",
        };

        // 创建IoC容器，并根据配置文件在容器中实例化对象
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
//        Apple sweetApple = context.getBean("sweetApple", Apple.class);
//        Apple sweetApple2 = (Apple) context.getBean("sweetApple");
//        System.out.println(sweetApple.getTitle());
//        // 从IoC容器中提取BeanId = "lilyChild" 的对象
//        Child lilyChild = context.getBean("lilyChild", Child.class);
//        lilyChild.eat();
//
//        Child andyChild = context.getBean("andyChild", Child.class);
//        andyChild.eat();
//
//        Child lunaChild = context.getBean("lunaChild", Child.class);
//        lunaChild.eat();

        // 如果存在多个，后面的会替代前面的
        Apple apple1 = context.getBean("apple1", Apple.class);
        System.out.println(apple1.getTitle());

        Apple apple2 = context.getBean("apple2", Apple.class);
        System.out.println(apple2.getTitle());

        Apple apple3 = context.getBean("apple3", Apple.class);
        System.out.println(apple3.getTitle());

    }
}
