package sky.pro.env_home_work8;

import org.junit.jupiter.api.Test;
import sky.pro.env_home_work8.domain.Employee;
import sky.pro.env_home_work8.service.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void employeeTestAdd() {
        Employee employee = new Employee("Иванc", "Ивановc", 5, 100000);
        out.addEmployee(employee);
        assertEquals(5, out.getEmployeeList().size());
    }

    @Test
    public void employeeTestDelete() {
        out.deleteEmployee(1);
        assertEquals(3, out.getEmployeeList().size());
    }

    @Test
    public void employeeTestSearch() {
        Employee employee = new Employee("Иван", "Иванов", 5, 50000);
        assertEquals(1, out.searchEmployee(employee));
    }
}



