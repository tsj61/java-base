package org.example.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String name;
    private int duration;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Project project = (Project) object;
        return duration == project.duration &&
                Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public String toString() {
        return "'" + name + "'" + "[" + duration + ']';
    }
}
