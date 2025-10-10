package com.example.employee_manager.payroll.dto.employee;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.dto.component.DeductionDto;
import com.example.employee_manager.payroll.dto.period.PayrollPeriodDto;

import java.math.BigDecimal;
import java.util.List;

public class EmployeePayrollSummaryDto {
    private Long id;
    private PayrollPeriodDto payrollPeriod;
    private BigDecimal grossPay;
    private BigDecimal netPay;
    private List<AllowanceDto> allowanceDtos;
    private List<DeductionDto> deductionDtos;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayrollPeriodDto getPayrollPeriod() {
        return payrollPeriod;
    }

    public void setPayrollPeriod(PayrollPeriodDto payrollPeriod) {
        this.payrollPeriod = payrollPeriod;
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

    public List<AllowanceDto> getAllowanceDtos() {
        return allowanceDtos;
    }

    public void setAllowanceDtos(List<AllowanceDto> allowanceDtos) {
        this.allowanceDtos = allowanceDtos;
    }

    public List<DeductionDto> getDeductionDtos() {
        return deductionDtos;
    }

    public void setDeductionDtos(List<DeductionDto> deductionDtos) {
        this.deductionDtos = deductionDtos;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
