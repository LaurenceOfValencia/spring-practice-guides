package com.example.employee_manager.payroll.dto.summary;

import java.util.List;

public class EmployeePayrollSummaryDto {

    private Long id;
    private String name;
    private List<EmployeePayrollDto> payrollRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeePayrollDto> getPayrollRecords() {
        return payrollRecords;
    }

    public void setPayrollRecords(List<EmployeePayrollDto> payrollRecords) {
        this.payrollRecords = payrollRecords;
    }
}
