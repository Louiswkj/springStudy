package com.imooc.spring.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @author liuliang
 * 2022/1/28
 */
@Repository
public class UserDao {
    public void insert() {
        System.out.println("新增用户数据");
    }
}
