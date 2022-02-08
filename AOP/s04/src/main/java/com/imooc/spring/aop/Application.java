package com.imooc.spring.aop;

import com.imooc.spring.aop.service.UserServiceProxy;
import com.imooc.spring.aop.service.UserServiceProxy1;
import com.imooc.spring.aop.service.impl.UserServiceImpl;

/**
 * @author liuliang
 * 2022/1/28
 */
public class Application {
    public static void main(String[] args) {
        UserServiceProxy1 userServiceProxy1 = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        userServiceProxy1.createUser();
    }
}
