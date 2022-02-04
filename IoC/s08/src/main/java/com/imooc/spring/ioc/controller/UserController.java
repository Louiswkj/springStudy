package com.imooc.spring.ioc.controller;

import com.imooc.spring.ioc.service.UserService;

/**
 * @author liuliang
 * 2022/1/27
 */
public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
