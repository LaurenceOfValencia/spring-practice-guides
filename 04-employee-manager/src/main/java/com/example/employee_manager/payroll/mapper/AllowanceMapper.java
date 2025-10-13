package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.entity.Allowance;
import org.springframework.stereotype.Component;

@Component
public class AllowanceMapper {

    public AllowanceDto toDto(Allowance allowance) {
        if (allowance == null) {
            return null;
        }
        AllowanceDto dto = new AllowanceDto();
        dto.setRecordId(allowance.getPayrollRecord().getId()); // references the parent payroll
        dto.setName(allowance.getName());
        dto.setAmount(allowance.getAmount());
        return dto;
    }

    public Allowance toEntity(AllowanceDto dto) {
        Allowance allowance = new Allowance();
        allowance.setName(dto.getName());
        allowance.setAmount(dto.getAmount());
        return allowance;
    }
}
