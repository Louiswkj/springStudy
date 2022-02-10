package com.imooc.spring.aop;

import com.imooc.spring.aop.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/28
 */
public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.createUser();
        userService.generateRandomPassword("字符串",6);

    }
}
