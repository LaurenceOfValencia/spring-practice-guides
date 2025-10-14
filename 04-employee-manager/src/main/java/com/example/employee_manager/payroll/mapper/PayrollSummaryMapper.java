package com.example.employee_manager.payroll.mapper;

import com.example.employee_manager.employee.entity.Employee;
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

    public EmployeePayrollSummaryDto toDtoEmployeePayrollSummary(Employee e, List<PayrollRecord> records) {
        if (e == null || records == null) {
            return null;
        }

        EmployeePayrollSummaryDto dto = new EmployeePayrollSummaryDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setPayrollRecords(records.stream().map(this::toDtoEmployeeSummaryPayroll).toList());
        return dto;
    }

    public EmployeePayrollDto toDtoEmployeeSummaryPayroll(PayrollRecord r) {
        if (r == null) {
            return null;
        }

        EmployeePayrollDto dto = new EmployeePayrollDto();
        dto.setPayrollPeriod(r.getPeriod().toString());
        dto.setGrossPay(r.getGrossPay());
        dto.setTotalDeductions(r.getDeductionList().stream().map(Deduction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        dto.setTotalAllowances(r.getAllowanceList().stream().map(Allowance::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        dto.setNetPay(r.getNetPay());

        return dto;
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
