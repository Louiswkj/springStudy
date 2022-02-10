package com.imooc.spring.ioc;

import com.imooc.spring.ioc.service.DepartmentService;
import com.imooc.spring.ioc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/27
 */
public class StringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.getUserDao());

//        DepartmentService departmentService = context.getBean("departmentService", DepartmentService.class);
//        System.out.println(departmentService.joinDepartment());


//        String[] beanIds = context.getBeanDefinitionNames();
//        for (String beanId : beanIds) {
//            System.out.println(beanId);
//        }
    }
}
