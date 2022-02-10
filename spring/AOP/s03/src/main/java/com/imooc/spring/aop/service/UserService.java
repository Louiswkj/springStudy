package com.imooc.spring.aop.service;

import com.imooc.spring.aop.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuliang
 * 2022/1/28
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public void createUser() {
        System.out.println("执行创建用户业务逻辑");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userDao.insert();
    }

    public String generateRandomPassword(String type, Integer length) {
        System.out.println("按" + type + "方式生成" + length + "位随机数");
        return "reqwcv3";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
