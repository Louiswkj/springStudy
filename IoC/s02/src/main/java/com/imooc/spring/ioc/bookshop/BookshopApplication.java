package com.imooc.spring.ioc.bookshop;

import com.imooc.spring.ioc.bookshop.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/24
 */
public class BookshopApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.purchase();
    }
}
