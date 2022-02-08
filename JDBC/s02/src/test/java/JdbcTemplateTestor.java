import com.imooc.spring.jdbc.dao.EmployeeDao;
import com.imooc.spring.jdbc.entity.Employee;
import com.imooc.spring.jdbc.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuliang
 * 2022/2/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTestor {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private EmployeeService employeeService;

    public void testFindById() {
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }

    @Test
    public void testFindByDname() {
        List<Employee> employees = employeeDao.findByDname("研发部");
        System.out.println(employees);
    }

    @Test
    public void testFindMapByDname() {
        List<Map<String, Object>> mapList = employeeDao.findMapByDname("研发部");
        System.out.println(mapList);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setEno(8888);
        employee.setEname("赵六");
        employee.setSalary(6666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeDao.findById(8888);
        employee.setSalary(employee.getSalary() + 1000);
        int count = employeeDao.update(employee);
        System.out.println("本次有" + count + "更新");
    }

    @Test
    public void testDelete() {
        int count = employeeDao.delete(8888);
        System.out.println("本次有" + count + "删除");
    }

    @Test
    public void testBatchImport() {
        employeeService.batchImport();
        System.out.println("批量导入成功");
    }
}
