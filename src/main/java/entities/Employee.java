package entities;

public class Employee {
    private String name;
    private Integer Salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }
}
