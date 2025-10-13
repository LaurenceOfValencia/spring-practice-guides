package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.payroll.dto.period.PayrollPeriodDto;
import com.example.employee_manager.payroll.entity.PayrollPeriod;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PayrollPeriodMapper {

    public PayrollPeriodDto toDto (PayrollPeriod period) {
        if (period == null) {
            return null;
        }
        PayrollPeriodDto dto = new PayrollPeriodDto();
        dto.setStartDate(period.getStartDate().toString());
        dto.setEndDate(period.getEndDate().toString());
        dto.setStatus(period.getStatus());
        return dto;
    }

    public PayrollPeriod toEntity(PayrollPeriodDto dto) {
        PayrollPeriod period = new PayrollPeriod();
        period.setStartDate(LocalDate.parse(dto.getStartDate()));
        period.setEndDate(LocalDate.parse(dto.getEndDate()));
        period.setStatus(dto.getStatus());
        return period;
    }
}
