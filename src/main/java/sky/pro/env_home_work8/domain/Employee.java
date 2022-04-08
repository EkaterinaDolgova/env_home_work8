package sky.pro.env_home_work8.domain;

import java.util.Objects;

public class Employee {
    private String name;
    private String family;
    private Integer department;
    private Integer salary;

    public Employee(String name, Integer department, Integer salary) {
        this.name = name;
        this.family = family;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String firstname, String lastname) {
    }

    public String getName() {
        return this.name;
    }

    public String getFamily() {
        return this.family;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && family.equals(employee.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family);
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + " Фамилия: " + this.family;
    }


}
