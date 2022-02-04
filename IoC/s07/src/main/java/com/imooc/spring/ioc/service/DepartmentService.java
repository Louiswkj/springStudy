package com.imooc.spring.ioc.service;

import com.imooc.spring.ioc.dao.IUserDao;
import com.imooc.spring.ioc.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuliang
 * 2022/1/27
 */
@Service
public class DepartmentService {
    /**
     * 1、@Resource设置name属性，则按name在IoC容器中将bean注入
     * 2、@Resource未设置name属性
     * 2.1、以属性名作为bean name在IoC容器中匹配bean，如果有匹配则注入
     * 2.2、按属性名未匹配，则按类型进行匹配，同@Autowried，需要加@Primary解决类型冲突
     * 使用建议：在使用@Resource对象时推荐设置name或抱住属性名和bean名称一致
     */
//    @Resource
//    private IUserDao userDao;

    @Resource(name = "userOracleDao")
    private IUserDao uDao;

    public IUserDao joinDepartment() {
        return uDao;
    }


}
