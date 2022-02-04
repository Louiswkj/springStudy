package com.imooc.spring.ioc.service;

import com.imooc.spring.ioc.dao.UserDao;

/**
 * @author liuliang
 * 2022/1/25
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        System.out.println("已加载UserService：" + this);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
