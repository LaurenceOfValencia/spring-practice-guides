package com.example.employee_manager.payroll.dto.summary;

import com.example.employee_manager.payroll.dto.period.PayrollPeriodDto;

import java.math.BigDecimal;

/**
 * Child component to EmployeePayrollSummary (payrolls grouped by employee)
 */
public class EmployeePayrollDto {
    private PayrollPeriodDto payrollPeriod;
    private BigDecimal grossPay;
    private BigDecimal totalDeductions;
    private BigDecimal totalAllowances;
    private BigDecimal netPay;

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
