package com.imooc.spring.ioc.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author liuliang
 * 2022/1/27
 * 组件类注解默认beanId为类名首字母小写
 * beanId = userDao
 * 也可以去设置 在@Repository("xxxxxxx")
 */
@Repository
@Primary
public class UserDao implements IUserDao{
    public UserDao() {
        System.out.println("正在创建UserDao" + this);
    }
}
