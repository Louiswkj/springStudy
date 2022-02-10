package com.imooc.spring.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @author liuliang
 * 2022/1/28
 */
@Repository
public class EmployeeDao {
    public void insert(){
        System.out.println("新增员工数据");
    }
}
