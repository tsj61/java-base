package org.example.aston_java_base.stream_api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int age;
    private List<Project> projects;
    private double salary;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return age == employee.age &&
                Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(projects, employee.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, projects, salary);
    }

    @Override
    public String toString() {
        return "Employee: " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", projects=" + projects +
                ", salary=" + salary;
    }
}
