package sky.pro.env_home_work8.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Employee;

import java.util.*;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAll() {
        return employeeService.getEmployeeList();
    }

    @Override
    public String amount(Integer department) {
        return employeeService.amount(department);
    }

    @Override
    public String maxSalary(Integer department) {
        return employeeService.maxSalary(department);
    }

    @Override
    public String minSalary(Integer department) {
        return employeeService.minSalary(department);
    }

    @Override
    public List<Employee> getAllDepartment(Integer department) {
        return employeeService.getAllDepartment(department);
    }

}
