package com.imooc.spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author liuliang
 * 2022/1/27
 * 组件类注解默认beanId为类名首字母小写
 * beanId = userDao
 * 也可以去设置 在@Repository("xxxxxxx")
 */
@Repository
public class UserOracleDao implements IUserDao{
    public UserOracleDao() {
        System.out.println("正在创建UserOracleDao" + this);
    }
}
