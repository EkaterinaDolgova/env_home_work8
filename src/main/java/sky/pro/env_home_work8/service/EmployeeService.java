package sky.pro.env_home_work8.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Employee;

import java.util.List;

@Service
public interface EmployeeService  {
    Employee getEmployee(Integer number);

    String addEmployee(Employee employees);

    String searchEmployee(Employee employee);

    String deleteEmployee(Integer id);

    List<Employee> getEmployeeList();

    String amount(Integer department);

    String maxSalary(Integer department);

    String minSalary(Integer department);

    List<Employee> getAllDepartment(Integer department);
}
