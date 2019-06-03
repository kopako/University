package com.botscrew.university.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments;

    public Lector() {
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
