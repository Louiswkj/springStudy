package com.imooc.spring.ioc.context;

/**
 * @author liuliang
 * 2022/1/25
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
