package com.example.employee_manager.payroll.dto.component;

import java.math.BigDecimal;

public class AllowanceDto {
    private Long recordId; // reference to parent payroll record
    private String name;
    private BigDecimal amount;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
