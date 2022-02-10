package com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/25
 */
public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Order order = context.getBean("order1", Order.class);
        order.pay();

        context.registerShutdownHook();
    }
}
