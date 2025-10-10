package com.example.employee_manager.employee.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date_hired;
    private String position;
    private boolean active;

    // public no-arg constructor
    public Employee() { }

    public Employee(Long id, String name, LocalDate date_hired, String position, boolean active ) {
        this.id = id;
        this.name = name;
        this.date_hired = date_hired;
        this.position = position;
        this.active = active;
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

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate_hired() {
        return date_hired;
    }

    public void setDate_hired(LocalDate date_hired) {
        this.date_hired = date_hired;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
