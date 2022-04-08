package sky.pro.env_home_work8.service;

import sky.pro.env_home_work8.domain.Department;
import sky.pro.env_home_work8.domain.Employee;

import java.awt.*;
import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    String amount(Integer department);

    String maxSalary(Integer department);

    String minSalary(Integer department);

    List<Department> getAllDepartment(Integer department);
}
