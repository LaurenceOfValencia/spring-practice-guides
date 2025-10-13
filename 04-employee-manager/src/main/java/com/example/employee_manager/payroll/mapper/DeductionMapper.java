package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.dto.component.DeductionDto;
import com.example.employee_manager.payroll.entity.Allowance;
import com.example.employee_manager.payroll.entity.Deduction;
import org.springframework.stereotype.Component;

@Component
public class DeductionMapper {

    public DeductionDto toDto(Deduction deduction) {
        if (deduction == null) {
            return null;
        }
        DeductionDto dto = new DeductionDto();
        dto.setRecordId(deduction.getPayrollRecord().getId()); // references the parent payroll
        dto.setName(deduction.getName());
        dto.setAmount(deduction.getAmount());
        return dto;
    }

    public Deduction toEntity(DeductionDto dto) {
        Deduction deduction = new Deduction();
        deduction.setName(dto.getName());
        deduction.setAmount(dto.getAmount());
        return deduction;
    }
}
