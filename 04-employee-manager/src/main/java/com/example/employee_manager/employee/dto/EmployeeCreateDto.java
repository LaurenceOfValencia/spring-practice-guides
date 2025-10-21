package com.example.employee_manager.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EmployeeCreateDto {

    private String name;
    private LocalDate dateHired;
    private String position;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
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
}
