package com.example.employee_manager.payroll.dto.record;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.dto.component.DeductionDto;
import com.example.employee_manager.payroll.entity.Allowance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PayrollRecordCreateDto {
    private Long periodId;
    private Long employeeId;
    private BigDecimal grossPay;
    private LocalDate paymentDate;
    private List<AllowanceDto> allowances;
    private List<DeductionDto> deductions;
    private String notes;

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public List<AllowanceDto> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<AllowanceDto> allowances) {
        this.allowances = allowances;
    }

    public List<DeductionDto> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<DeductionDto> deductions) {
        this.deductions = deductions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
