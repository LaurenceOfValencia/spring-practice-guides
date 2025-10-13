package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.payroll.dto.record.PayrollRecordDto;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class serves as a parent mapper
 */

@Component
public class PayrollRecordMapper {

    @Autowired
    private PayrollPeriodMapper periodMapper;
    @Autowired
    private AllowanceMapper allowanceMapper;
    @Autowired
    private DeductionMapper deductionMapper;

    public PayrollRecordDto toDto(PayrollRecord record) {
        if (record == null) {
            return null;
        }
        PayrollRecordDto dto = new PayrollRecordDto();
        dto.setEmployee(record.getEmployee().getName());
        // How would I handle the payroll period here?
        dto.setPeriod(periodMapper.toDto(record.getPeriod()));
        dto.setGrossPay(record.getGrossPay());
        dto.setNetPay(record.getNetPay());
        dto.setPaymentDate(record.getPaymentDate());
        dto.setNotes(record.getNotes());
        dto.setAllowances(record.getAllowanceList().stream().map(allowanceMapper::toDto).toList());
        dto.setDeductions(record.getDeductionList().stream().map(deductionMapper::toDto).toList());
        return dto;
    }
}
