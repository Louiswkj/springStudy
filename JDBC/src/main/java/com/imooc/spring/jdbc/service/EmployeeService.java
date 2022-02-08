package com.imooc.spring.jdbc.service;

import com.imooc.spring.jdbc.dao.EmployeeDao;
import com.imooc.spring.jdbc.entity.Employee;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuliang
 * 2022/2/8
 */
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DataSourceTransactionManager transactionManager;

    public void batchImport() {
        // 定义事务默认的标准配置
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        // 开始一个事务 返回事务状态，事务状态说明了当前事务的执行阶段
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            for (int i = 1; i <= 10; i++) {
//                if (i == 3) {
//                    throw new RuntimeException("意料之中的异常");
//                }
                Employee employee = new Employee();
                employee.setEno(8000 + i);
                employee.setEname("员工" + i);
                employee.setSalary(4000f);
                employee.setDname("市场部");
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }


    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public DataSourceTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
