package com.imooc.spring.ioc.factory;

import com.imooc.spring.ioc.entity.Apple;

/**
 * @author liuliang
 * 2022/1/22
 * 工厂实例方法创建对象是指IoC容器对工厂类进行实例化并调用对应的实例方法创建对象的过程
 */
public class AppleFactoryInstance {
    public Apple createSweetApple() {
        System.out.println("AppleFactoryInstance-createSweetApple");
        return new Apple("红富士", "红色", "欧洲");
    }
}
