package com.example.employee_manager.payroll.entity;

import com.example.employee_manager.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "payroll_records")
public class PayrollRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "period_id")
    @JsonIgnore
    private PayrollPeriod period;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @OneToMany(mappedBy = "payrollRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Allowance> allowanceList;

    @OneToMany(mappedBy = "payrollRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Deduction> deductionList;

    private BigDecimal grossPay;
    private BigDecimal netPay;
    private LocalDate paymentDate;
    private String notes;

    public PayrollRecord() {
    }

    public PayrollRecord(long id, PayrollPeriod period, Employee employee, BigDecimal grossPay, BigDecimal netPay, LocalDate paymentDate) {
        this.id = id;
        this.period = period;
        this.employee = employee;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.paymentDate = paymentDate;
    }

    public PayrollRecord(long id, PayrollPeriod period, Employee employee, BigDecimal grossPay, BigDecimal netPay, LocalDate paymentDate, String notes) {
        this.id = id;
        this.period = period;
        this.employee = employee;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.paymentDate = paymentDate;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PayrollPeriod getPeriod() {
        return period;
    }

    public void setPeriod(PayrollPeriod period) {
        this.period = period;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Allowance> getAllowanceList() {
        return allowanceList;
    }

    public void setAllowanceList(List<Allowance> allowanceList) {
        this.allowanceList = allowanceList;
    }

    public List<Deduction> getDeductionList() {
        return deductionList;
    }

    public void setDeductionList(List<Deduction> deductionList) {
        this.deductionList = deductionList;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
