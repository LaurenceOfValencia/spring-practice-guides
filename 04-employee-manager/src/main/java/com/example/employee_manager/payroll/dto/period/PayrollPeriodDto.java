package com.example.employee_manager.payroll.dto.period;

import com.example.employee_manager.payroll.entity.PayrollPeriod;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PayrollPeriodDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endDate;
    private PayrollPeriod.Status status;

    public String getPeriod() {
        return startDate + " to " + endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public PayrollPeriod.Status getStatus() {
        return status;
    }

    public void setStatus(PayrollPeriod.Status status) {
        this.status = status;
    }
}
