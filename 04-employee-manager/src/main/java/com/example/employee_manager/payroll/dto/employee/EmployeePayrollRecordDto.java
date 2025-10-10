package com.example.employee_manager.payroll.dto.employee;

import jakarta.persistence.ManyToOne;

import java.util.List;

public class EmployeePayrollRecordDto {

    private Long employeeId;
    private String employeeName;
    private List<EmployeePayrollSummaryDto> payrollRecords;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<EmployeePayrollSummaryDto> getPayrollRecords() {
        return payrollRecords;
    }

    public void setPayrollRecords(List<EmployeePayrollSummaryDto> payrollRecords) {
        this.payrollRecords = payrollRecords;
    }
}
