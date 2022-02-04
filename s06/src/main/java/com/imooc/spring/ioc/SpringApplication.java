package com.imooc.spring.ioc;

import com.imooc.spring.ioc.context.ClassPathXmlApplicationContext;
import com.imooc.spring.ioc.entity.Apple;

/**
 * @author liuliang
 * 2022/1/25
 */
public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Apple sweetApple = (Apple) context.getBean("sweetApple");
        System.out.println(sweetApple);
    }
}
