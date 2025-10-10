package com.example.employee_manager.payroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "allowances")
public class Allowance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "record_id")
    @JsonIgnore
    private PayrollRecord payrollRecord;

    private String type;
    private BigDecimal amount;

    public Allowance() {
    }

    public Allowance(long id, PayrollRecord payrollRecord, String type, BigDecimal amount) {
        this.id = id;
        this.payrollRecord = payrollRecord;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
