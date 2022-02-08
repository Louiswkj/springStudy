package com.imooc.spring.aop.service.impl;

import com.imooc.spring.aop.service.UserService;

/**
 * @author liuliang
 * 2022/1/28
 */
public class UserServiceImpl implements UserService {
    public void createUser() {
        System.out.println("执行新增用户业务代码");
    }
}
