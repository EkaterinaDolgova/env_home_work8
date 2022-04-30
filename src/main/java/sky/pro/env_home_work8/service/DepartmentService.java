package sky.pro.env_home_work8.service;

import sky.pro.env_home_work8.domain.Employee;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {

    List<Employee> getAll();

    String amount(Integer department);

    Integer maxSalary(Integer department);

    Integer minSalary(Integer department);

    List<Employee> getAllDepartment(Integer department);
}
