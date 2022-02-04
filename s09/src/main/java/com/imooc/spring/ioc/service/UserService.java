package com.imooc.spring.ioc.service;

import com.imooc.spring.ioc.dao.UserDao;

/**
 * @author liuliang
 * 2022/1/27
 */
public class UserService {
    private UserDao userDao;

    public void createUser(){
        System.out.println("调用创建用户的业务代码");
        userDao.insert();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
