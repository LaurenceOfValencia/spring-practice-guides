package com.example.employee_manager.payroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "deductions")
public class Deduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "record_id")
    @JsonIgnore
    private PayrollRecord payrollRecord;

    @Column(name = "type", nullable = false)
    private String name;
    private BigDecimal amount;

    public Deduction() {
    }

    public Deduction(long id, PayrollRecord payrollRecord, String name, BigDecimal amount) {
        this.id = id;
        this.payrollRecord = payrollRecord;
        this.name = name;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PayrollRecord getPayrollRecord() {
        return payrollRecord;
    }

    public void setPayrollRecord(PayrollRecord payrollRecord) {
        this.payrollRecord = payrollRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
