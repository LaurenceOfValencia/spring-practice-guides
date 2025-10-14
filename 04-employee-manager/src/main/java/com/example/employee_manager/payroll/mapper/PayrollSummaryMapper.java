package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.payroll.dto.summary.EmployeePayrollDto;
import com.example.employee_manager.payroll.dto.summary.EmployeePayrollSummaryDto;
import com.example.employee_manager.payroll.dto.summary.PayrollPeriodSummaryDto;
import com.example.employee_manager.payroll.dto.summary.PeriodPayrollDto;
import com.example.employee_manager.payroll.entity.Allowance;
import com.example.employee_manager.payroll.entity.Deduction;
import com.example.employee_manager.payroll.entity.PayrollPeriod;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PayrollSummaryMapper {

    /**
     * Payroll summary by Employee
     * use EmployeePayrollRecordDto
     */

    public EmployeePayrollSummaryDto toDtoEmployeePayrollSummary(List<PayrollRecord> records) {
        // check nulls


        return null;
    }

    public EmployeePayrollDto toDtoEmployeeSummaryPayroll(PayrollRecord record) {
        return null;
    }

    /**
     * Payroll summary by Period
     * use PayrollPeriodSummaryDto
     */

    public PayrollPeriodSummaryDto toDtoPeriodSummary(PayrollPeriod p, List<PayrollRecord> records) {
        if (p == null || records == null) {
            return null;
        }

        PayrollPeriodSummaryDto dto = new PayrollPeriodSummaryDto();
        dto.setPeriodStart(p.getStartDate().toString());
        dto.setPeriodEnd(p.getEndDate().toString());
        dto.setRecords(toDtoPeriodPayrollDto(records));
        return dto;
    }

    public List<PeriodPayrollDto> toDtoPeriodPayrollDto(List<PayrollRecord> records) {
        if(records == null) {
            return null;
        }

        return records.stream().map(record -> {
            PeriodPayrollDto dto = new PeriodPayrollDto();
            dto.setEmployeeName(record.getEmployee().getName());
            dto.setGrossPay(record.getGrossPay());
            dto.setTotalDeductions(record.getDeductionList().stream().map(Deduction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            dto.setTotalAllowances(record.getAllowanceList().stream().map(Allowance::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            dto.setNetPay(record.getNetPay());
            dto.setPaymentDate(record.getPaymentDate());
            return dto;
        }).toList();
    }


}
