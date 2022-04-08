package sky.pro.env_home_work8.service;

import sky.pro.env_home_work8.domain.Employee;

import java.awt.*;
import java.util.List;

public interface DepartmentService {
    List<Employee> getAll();

    String amount(Integer department);

    String maxSalary(Integer department);
    String minSalary(Integer department);

    String getAllDepartment(Integer department);
}
