package com.imooc.spring.jdbc.dao;

import com.imooc.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author liuliang
 * 2022/2/4
 */
@Repository
public class EmployeeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Employee findById(Integer eno) {
        String sql = " select * from `employee` where eno = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{eno}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> findByDname(String dname) {
        String sql = " select * from `employee` where dname = ? ";
        return jdbcTemplate.query(sql, new Object[]{dname}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Map<String, Object>> findMapByDname(String dname) {
        String sql = " select eno as empno, salary as money, dname as departmentName from `employee` where dname = ? ";
        return jdbcTemplate.queryForList(sql, new Object[]{dname});
    }

    public void insert(Employee employee) {
        String sql = "insert into `employee` (`eno`, `ename`, `salary`, `dname`, `hiredate`) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                employee.getEno(), employee.getEname(), employee.getSalary(), employee.getDname(), employee.getHiredate()
        });
    }

    public int update(Employee employee) {
        String sql = "update `employee` set `ename` = ? , `salary` = ? , `dname` = ? ,`hiredate` = ? where `eno` = ? ";
        int count = jdbcTemplate.update(sql, new Object[]{
                employee.getEname(), employee.getSalary(), employee.getDname(), employee.getHiredate(), employee.getEno()
        });
        return count;
    }

    public int delete(Integer eno) {
        String sql = "DELETE from `employee` where eno = ?";
        int count = jdbcTemplate.update(sql, new Object[]{eno});
        return count;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
