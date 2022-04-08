package sky.pro.env_home_work8.service;
import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentImpl implements DepartmentService{
    private final List<Employee> employees = new ArrayList(List.of(
            new Employee("Петров Петр Петрович", 1, 20000),
            new Employee("Иванов Иван Иванович", 2, 30000),
            new Employee("Сидоров Степан Геннадьевич", 1, 50000),
            new Employee("Степашкин Иван Федорович", 3, 10000),
            new Employee("Петров Илья Иванович", 4, 100000),
            new Employee("Арбузов Андрей Александрович", 5, 40000),
            new Employee("Арбузов Артем Александрович", 5, 45000),
            new Employee("Цветков Максим Викторович", 3, 50000),
            new Employee("Цветков Алексей Петрович", 1, 70000),
            new Employee("Симбирцев Михаил Андреевич", 4, 60000)
    ));
    @Override
    public List<Employee> getAll() {
        return employees;
    }


    @Override
    public String amount(Integer department) {
        int costAmount = 0;
        double averageSalary = 0;
        final Integer sum = employees.stream()
                .filter(e->e.getDepartment()==department).mapToInt(e -> e.getSalary()).sum();
        final Integer count = Math.toIntExact(employees.stream()
                .filter(e -> e.getDepartment() == department).count());
        costAmount =sum*30;
        averageSalary = sum / count;
        return "Сумма затрат на зарплаты в месяц: " + costAmount +
                "р. : Среднее значение зарплат: " + averageSalary + "р. в отделе № " + department;
    }

    @Override
    public String maxSalary(Integer department) {
        final Optional<Employee> maxSalary = employees.stream()
                .filter(e->e.getDepartment()==department)
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary));
        return "Сотрудник с максимальной зарплатой: " + maxSalary + "р.";
    }

    @Override
    public String minSalary(Integer department) {
        final Optional<Employee> minSalary = employees.stream()
                .filter(e->e.getDepartment()==department)
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));
        return "Сотрудник с минимальной зарплатой: " + minSalary + "р.";
    }

    @Override
    public String getAllDepartment(Integer department) {
        return null;
    }
}
