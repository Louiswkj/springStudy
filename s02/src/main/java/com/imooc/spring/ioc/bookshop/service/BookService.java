package com.imooc.spring.ioc.bookshop.service;

import com.imooc.spring.ioc.bookshop.dao.BookDao;

/**
 * @author liuliang
 * 2022/1/24
 */
public class BookService {
    private BookDao bookDao;

    public void purchase(){
        System.out.println("正在之心图书采购业务方法");
        bookDao.insert();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

}
