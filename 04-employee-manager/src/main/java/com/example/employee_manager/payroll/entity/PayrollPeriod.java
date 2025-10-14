package com.example.employee_manager.payroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *  PayrollPeriod
 *
 *  Description:
 *      describes a point in time where a payroll record applies. Usually bi-monthly
 */

@Entity
@Table(name = "payroll_periods")
public class PayrollPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    private List<PayrollRecord> payrollRecords;

    public enum Status {
        OPEN,
        CLOSED
    }

    public PayrollPeriod() {}

    public PayrollPeriod(Long id, LocalDate startDate, LocalDate endDate, Status status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<PayrollRecord> getPayrollRecords() {
        return payrollRecords;
    }

    public void setPayrollRecords(List<PayrollRecord> payrollRecords) {
        this.payrollRecords = payrollRecords;
    }

    @Override
    public String toString() {
        return startDate + " -> " + endDate;
    }
}
