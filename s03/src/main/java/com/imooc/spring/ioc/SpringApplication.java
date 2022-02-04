package com.imooc.spring.ioc;

import com.imooc.spring.ioc.entity.Company;
import com.imooc.spring.ioc.entity.Computer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliang
 * 2022/1/24
 */
public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
        String website = company.getInfo().getProperty("website");
        System.out.println(website);

        System.out.println("======================");
        //
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName:beanNames){
            System.out.println(beanName);
        }

        Computer computer = context.getBean("com.imooc.spring.ioc.entity.Computer", Computer.class);
    }
}
