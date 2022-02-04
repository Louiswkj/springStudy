package com.imooc.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liuliang
 * 2022/1/27
 */
public class StringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] beanIds = context.getBeanDefinitionNames();
        for (String beanId : beanIds) {
            System.out.println(beanId);
        }
    }
}
