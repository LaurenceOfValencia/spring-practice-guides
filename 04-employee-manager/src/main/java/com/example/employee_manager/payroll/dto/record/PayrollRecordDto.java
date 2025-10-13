package com.example.employee_manager.payroll.dto.record;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.dto.component.DeductionDto;
import com.example.employee_manager.payroll.dto.period.PayrollPeriodDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollRecordDto {

    private String employee;
    private PayrollPeriodDto period;
    private BigDecimal grossPay;
    private BigDecimal netPay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private String notes;

    private List<DeductionDto> deductions = new ArrayList<>();
    private List<AllowanceDto> allowances = new ArrayList<>();

    private BigDecimal totalDeductions;
    private BigDecimal totalAllowances;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public PayrollPeriodDto getPeriod() {
        return period;
    }

    public void setPeriod(PayrollPeriodDto period) {
        this.period = period;
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

    public List<DeductionDto> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<DeductionDto> deductions) {
        this.deductions = deductions;
    }

    public List<AllowanceDto> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<AllowanceDto> allowances) {
        this.allowances = allowances;
    }

    public BigDecimal getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(BigDecimal totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public BigDecimal getTotalAllowances() {
        return totalAllowances;
    }

    public void setTotalAllowances(BigDecimal totalAllowances) {
        this.totalAllowances = totalAllowances;
    }
}
