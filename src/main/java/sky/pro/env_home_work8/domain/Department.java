package sky.pro.env_home_work8.domain;

public class Department {
    private String name;
    private Integer department;
    private Integer salary;


    public Department(String name, Integer department, Integer salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Имя: " + this.name + " Отдел: " + this.department+ " Зарплата: " + this.salary;
    }
}

