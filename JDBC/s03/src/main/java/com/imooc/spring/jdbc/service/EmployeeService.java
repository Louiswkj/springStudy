package com.imooc.spring.jdbc.service;

import com.imooc.spring.jdbc.dao.EmployeeDao;
import com.imooc.spring.jdbc.entity.Employee;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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
// 声明式事务核心注解
// 放在类上，将声明式事务配置应用于当前类的所有方法，默认事务传播为 REQUIRED
@Transactional
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private BatchService batchService;


    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Employee findById(Integer eno) {
        return employeeDao.findById(eno);
    }

    public void batchImport() {
        for (int i = 1; i <= 10; i++) {
//            if (i == 3) {
//                throw new RuntimeException("意料之中的异常");
//            }
            Employee employee = new Employee();
            employee.setEno(8000 + i);
            employee.setEname("员工" + i);
            employee.setSalary(4000f);
            employee.setDname("市场部");
            employee.setHiredate(new Date());
            employeeDao.insert(employee);
        }
    }

    public void startImportJob() {
        batchService.importJob1();
        if (true) {
            throw new RuntimeException("意料之中的异常");
        }
        batchService.importJob2();
        System.out.println("批量导入成功");
    }


    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


}
