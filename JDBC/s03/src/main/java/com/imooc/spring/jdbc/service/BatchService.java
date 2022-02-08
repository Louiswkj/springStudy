package com.imooc.spring.jdbc.service;

import com.imooc.spring.jdbc.dao.EmployeeDao;
import com.imooc.spring.jdbc.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuliang
 * 2022/2/8
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BatchService {
    @Resource
    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importJob1() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(8100 + i);
            employee.setEname("市场部门员工" + i);
            employee.setSalary(4000f);
            employee.setDname("市场部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void importJob2() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setEno(8200 + i);
            employee.setEname("研发部门员工" + i);
            employee.setSalary(4000f);
            employee.setDname("研发部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }

}
