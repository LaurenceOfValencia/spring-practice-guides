package com.example.employee_manager.payroll.dto.period;

import com.example.employee_manager.payroll.entity.PayrollPeriod;

import java.util.List;

public class PayrollPeriodSummaryDto {
    private PayrollPeriodDto period;
    private List<PayrollPeriodEmployeeRecordDto> records;

    public PayrollPeriodDto getPeriod() {
        return period;
    }

    public void setPeriod(PayrollPeriodDto period) {
        this.period = period;
    }

    public List<PayrollPeriodEmployeeRecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<PayrollPeriodEmployeeRecordDto> records) {
        this.records = records;
    }
}
