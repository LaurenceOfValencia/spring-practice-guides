package com.example.employee_manager.payroll.dto.summary;

import com.example.employee_manager.payroll.dto.period.PayrollPeriodDto;

import java.util.List;

public class PayrollPeriodSummaryDto {
    private String periodStart;
    private String periodEnd;
    private List<PeriodPayrollDto> records;

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public List<PeriodPayrollDto> getRecords() {
        return records;
    }

    public void setRecords(List<PeriodPayrollDto> records) {
        this.records = records;
    }
}
