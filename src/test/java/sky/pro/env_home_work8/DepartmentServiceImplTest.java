package sky.pro.env_home_work8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.env_home_work8.domain.Employee;
import sky.pro.env_home_work8.exception.EmployeeNotFoundException;
import sky.pro.env_home_work8.service.DepartmentServiceImpl;
import sky.pro.env_home_work8.service.EmployeeService;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    private static Stream<Arguments> argumentsDepartmentTestMax() {
        return Stream.of(
                Arguments.of(5, 54000),
                Arguments.of(1, 140000)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsDepartmentTestMax")
    public void paramTestMax(int department, int expected) {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(expected, out.maxSalary(department));
    }

    private static Stream<Arguments> argumentsDepartmentTestMin() {
        return Stream.of(
                Arguments.of(5, 50000),
                Arguments.of(1, 100000)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsDepartmentTestMin")
    public void paramTestMin(int department, int expected) {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(expected, out.minSalary(department));
    }

    @Test
    public void departmentTestAmount() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals("3120000,52000.0", out.amount(2));
    }

    @Test
    public void testWithNullDepThrowsException() {
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(null));
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(null));
        assertThrows(EmployeeNotFoundException.class, () -> out.amount(null));

    }
}
