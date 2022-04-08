package sky.pro.env_home_work8.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Employee;

import java.util.Collection;
import java.util.Map;

@Service
public interface EmployeeService  {
    Employee getEmployee(Integer number);

    String addEmployee(Employee employees);

    String searchEmployee(Employee employee);

    String deleteEmployee(Integer id);

    Map<Integer, Employee> getEmployeeList();

}
