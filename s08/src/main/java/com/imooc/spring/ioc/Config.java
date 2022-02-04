package com.imooc.spring.ioc;

import com.imooc.spring.ioc.controller.UserController;
import com.imooc.spring.ioc.dao.UserDao;
import com.imooc.spring.ioc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuliang
 * 2022/1/27
 */
@Configuration // 当前类是一个配置类，用于替代applicationContext.xml
@ComponentScan(basePackages = "com.imooc")
public class Config {
    @Bean // Java Config 利用方法创建对象，将方法返回对象放入容器，beanId=方法名
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        System.out.println("已创建UserDao");
        return userDao;
    }

    @Bean
    // 先按name尝试注入，name不存在则按类型注入
    public UserService userService(UserDao userDao) {
        UserService userService = new UserService();
        System.out.println("已创建userService");
        userService.setUserDao(userDao);
        System.out.println("调用setUserDao");
        return userService;
    }

    @Bean
    public UserController userController(UserService userService) {
        UserController userController = new UserController();
        System.out.println("已创建userController");
        userController.setUserService(userService);
        System.out.println("调用setUserController");
        return userController;
    }
}
