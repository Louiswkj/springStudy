package com.imooc.spring.aop.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuliang
 * 2022/1/28
 */
public class UserServiceProxy implements UserService {
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        System.out.println("========"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss").format(new Date()) +"==========");
        userService.createUser();
    }
}
