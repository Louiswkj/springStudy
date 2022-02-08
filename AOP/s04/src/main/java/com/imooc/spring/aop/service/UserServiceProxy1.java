package com.imooc.spring.aop.service;


/**
 * @author liuliang
 * 2022/1/28
 */
public class UserServiceProxy1 implements UserService {
    private UserService userService;

    public UserServiceProxy1(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        userService.createUser();
        System.out.println("========后置扩展内容==========");

    }
}
