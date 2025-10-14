package com.example.employee_manager.payroll.dto.summary;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Child component to PayrollPeriodSummary (payrolls grouped by period)
 */
public class PeriodPayrollDto {
    private String employeeName;
    private BigDecimal grossPay;
    private BigDecimal totalDeductions;
    private BigDecimal totalAllowances;
    private BigDecimal netPay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
