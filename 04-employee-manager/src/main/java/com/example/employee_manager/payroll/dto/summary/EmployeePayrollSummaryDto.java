package com.example.employee_manager.payroll.dto.summary;

import java.util.List;

public class EmployeePayrollSummaryDto {

    private Long employeeId;
    private String employeeName;
    private List<EmployeePayrollDto> payrollRecords;

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

    public List<EmployeePayrollDto> getPayrollRecords() {
        return payrollRecords;
    }

    public void setPayrollRecords(List<EmployeePayrollDto> payrollRecords) {
        this.payrollRecords = payrollRecords;
    }
}
