package com.botscrew.university.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "department_lectors",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id")
    )
    private List<Lector> lectors;

    public Department() {
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

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lectors=" + lectors +
                '}';
    }
}
