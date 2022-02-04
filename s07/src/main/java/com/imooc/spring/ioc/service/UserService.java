package com.imooc.spring.ioc.service;

import com.imooc.spring.ioc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liuliang
 * 2022/1/27
 */
@Service
@Scope("prototype") // 设置单例/多例，与XML中的scope配置一样
public class UserService {
    // Spring IoC容器会自动通过反射技术将属性private修饰符自动改为public，直接进行赋值
    // 不会执行set方法
    @Autowired
    private IUserDao uDao;

    @PostConstruct // XML中init-method相同
    public void init() {
        System.out.println("初始化UserService:init方法");
    }

    public UserService() {
        System.out.println("正在创建UserService：" + this);
    }

    public IUserDao getUserDao() {
        return uDao;
    }
    //如果把装配注解放到set方法上，则自动按照类型、名称对set方法参数进行注入
//    @Autowired
//    public void setUserDao(IUserDao userDao) {
//        System.out.println("setUserDao:" + userDao);
//        this.userDao = userDao;
//    }
}
