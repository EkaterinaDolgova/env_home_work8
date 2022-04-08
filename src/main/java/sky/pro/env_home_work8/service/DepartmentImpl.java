package sky.pro.env_home_work8.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work8.domain.Department;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentImpl implements DepartmentService {
    private final List<Department> departments = new ArrayList(List.of(
            new Department("Петров Петр Петрович", 1, 20000),
            new Department("Иванов Иван Иванович", 2, 30000),
            new Department("Сидоров Степан Геннадьевич", 1, 50000),
            new Department("Степашкин Иван Федорович", 3, 10000),
            new Department("Петров Илья Иванович", 4, 100000),
            new Department("Арбузов Андрей Александрович", 5, 40000),
            new Department("Арбузов Артем Александрович", 5, 45000),
            new Department("Цветков Максим Викторович", 3, 50000),
            new Department("Цветков Алексей Петрович", 1, 70000),
            new Department("Симбирцев Михаил Андреевич", 4, 60000)
    ));

    @Override
    public List<Department> getAll() {
        return departments;
    }


    @Override
    public String amount(Integer department) {
        int costAmount = 0;
        double averageSalary = 0;
        final Integer sum = departments.stream()
                .filter(e -> e.getDepartment() == department).mapToInt(e -> e.getSalary()).sum();
        final Integer count = Math.toIntExact(departments.stream()
                .filter(e -> e.getDepartment() == department).count());
        costAmount = sum * 30;
        averageSalary = sum / count;
        return "Сумма затрат на зарплаты в месяц: " + costAmount +
                "р. : Среднее значение зарплат: " + averageSalary + "р. в отделе № " + department;
    }

    @Override
    public String maxSalary(Integer department) {
        final Optional<Department> maxSalary = departments.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Department::getSalary));
        return "Сотрудник с максимальной зарплатой: " + maxSalary + "р.";
    }

    @Override
    public String minSalary(Integer department) {
        final Optional<Department> minSalary = departments.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Department::getSalary));
        return "Сотрудник с минимальной зарплатой: " + minSalary + "р.";
    }

    @Override
    public List<Department> getAllDepartment(Integer department) {
        final List<Department> allDepartments = departments.stream()
                .filter(e -> e.getDepartment() == department).
                collect(Collectors.toList());
        return allDepartments;
    }
}
