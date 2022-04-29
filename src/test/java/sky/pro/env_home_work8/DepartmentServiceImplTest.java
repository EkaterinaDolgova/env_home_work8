package sky.pro.env_home_work8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.env_home_work8.domain.Employee;
import sky.pro.env_home_work8.service.DepartmentServiceImpl;
import sky.pro.env_home_work8.service.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceImplTest {
    private static List<Employee> employees = List.of(
            new Employee("Иван", "Иванов", 5, 50000),
            new Employee("Петр", "Петров", 5, 54000),
            new Employee("Владимир", "Иванченко", 1, 100000),
            new Employee("Степан", "Казанцев", 1, 140000));
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void departmentTestMax() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(54000, out.maxSalary(5));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(50000, out.maxSalary(5));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(50000, out.maxSalary(1));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(140000, out.maxSalary(1));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(140000, out.maxSalary(null));
    }

    @Test
    public void departmentTestMin() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(50000, out.minSalary(0));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(50000, out.minSalary(5));
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(50000, out.minSalary(1));
    }

    @Test
    public void departmentTestAmount() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals("3120000,52000.0", out.amount(2));
    }
}
