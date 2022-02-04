package com.imooc.spring.ioc.bookshop.dao.impl;

import com.imooc.spring.ioc.bookshop.dao.BookDao;

/**
 * @author liuliang
 * 2022/1/24
 */
public class BookOracleDaoImpl implements BookDao {
    @Override
    public void insert() {
        System.out.println("像Oracle book标中插入一条数据");
    }
}
