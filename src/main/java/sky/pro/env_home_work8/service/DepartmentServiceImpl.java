package sky.pro.env_home_work8.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Employee;
import sky.pro.env_home_work8.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAll() {
        return employeeService.getEmployeeList();
    }

    @Override
    public String amount(Integer department) {
        if (department == null|| department==0){
            throw new EmployeeNotFoundException("Номер отделения пустой");
        }
        int costAmount = 0;
        double averageSalary = 0;
        final Integer sum = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).mapToInt(e -> e.getSalary()).sum();
        final Integer count = Math.toIntExact(employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).count());
        costAmount = sum * 30;
        averageSalary = sum / count;
        return costAmount +
                "," + averageSalary;
    }

    @Override
    public Integer maxSalary(Integer department) {
        if (department == null|| department==0){
            throw new EmployeeNotFoundException("Номер отделения пустой");
        }
        final Integer maxSalary = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary)).get().getSalary();
        return maxSalary;
    }

    @Override
    public Integer minSalary(Integer department) {
        if (department == null|| department==0){
            throw new EmployeeNotFoundException("Номер отделения пустой");
        }
        final Integer minSalary = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary)).get().getSalary();
        return  minSalary;
    }

    @Override
    public List<Employee> getAllDepartment(Integer department) {
        final List<Employee> allDepartments = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).
                collect(Collectors.toList());
        return allDepartments;
    }
}
