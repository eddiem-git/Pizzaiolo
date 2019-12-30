package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pizzaiolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String employeeId;

    private String specialty;

    public Pizzaiolo() {
    }

    public Pizzaiolo(String name, String employeeId, String specialty) {
        this(null, name, employeeId, specialty);
    }

    public Pizzaiolo(Long id, String name, String employeeId, String specialty) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizzaiolo pizzaiolo = (Pizzaiolo) o;
        return Objects.equals(id, pizzaiolo.id) &&
                Objects.equals(name, pizzaiolo.name) &&
                Objects.equals(employeeId, pizzaiolo.employeeId) &&
                Objects.equals(specialty, pizzaiolo.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeeId, specialty);
    }
}