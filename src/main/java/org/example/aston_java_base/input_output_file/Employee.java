package org.example.aston_java_base.input_output_file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private String surname;
    private String name;
    private int age;
    private double salary;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return age == employee.age && Double.compare(salary, employee.salary) == 0 && Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, age, salary);
    }

    @Override
    public String toString() {
        return surname + ", " + name + ", " + age + ", " + salary + ";";
    }
}
