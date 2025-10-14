package com.example.employee_manager.payroll.service;

import com.example.employee_manager.payroll.dto.record.PayrollRecordDto;
import com.example.employee_manager.payroll.dto.summary.PayrollPeriodSummaryDto;
import com.example.employee_manager.payroll.entity.PayrollPeriod;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import com.example.employee_manager.payroll.mapper.PayrollRecordMapper;
import com.example.employee_manager.payroll.mapper.PayrollSummaryMapper;
import com.example.employee_manager.payroll.repository.PayrollPeriodRepository;
import com.example.employee_manager.payroll.repository.PayrollRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PayrollRecordService {
    @Autowired
    PayrollRecordMapper payrollMapper;
    @Autowired
    PayrollSummaryMapper payrollSummaryMapper;
    @Autowired
    PayrollRecordRepository payrollRecordRepository;
    @Autowired
    PayrollPeriodRepository periodRepository;
    /**
     *  Have the usual crud methods
     */
    public PayrollRecordDto createPayrollRecord(PayrollRecord record) {
        payrollRecordRepository.save(record);
        return payrollMapper.toDto(payrollRecordRepository.findById(record.getId()).isPresent() ? record : null);
    }

    public PayrollRecordDto getPayrollRecordById(Long id) {
        return payrollMapper.toDto(payrollRecordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No payroll record found for id: " + id)));
    }

    public List<PayrollRecordDto> getAllPayrollRecords() {
        return payrollRecordRepository.findAll().stream()
                .map(payrollMapper::toDto)
                .toList();
    }

    /**
     * Find by period
     */
    public List<PayrollRecordDto> getPayrollRecordsByPeriod(LocalDate periodStart, LocalDate periodEnd) {
        PayrollPeriod period = periodRepository.findByStartDateAndEndDate(periodStart, periodEnd);
        return payrollRecordRepository.findByPeriodId(period.getId())
                .stream()
                .map(payrollMapper::toDto)
                .toList();
    }

    public PayrollPeriodSummaryDto getPayrollRecordsByPeriodSummary(LocalDate periodStart, LocalDate periodEnd) {
        PayrollPeriod period = periodRepository.findByStartDateAndEndDate(periodStart, periodEnd);
        List<PayrollRecord> records = payrollRecordRepository.findByPeriodId(period.getId());
        return payrollSummaryMapper.toDtoPeriodSummary(period, records);
    }

    /**
     * find by employee
     */


//    public PayrollRecordDto updatePayrollRecord(Long id, PayrollRecordDto updatedPayrollRecord) {
//        PayrollRecord update = repository.findById(id)
//                .map(payroll -> {
//                    payroll.setEmployee(updatedPayrollRecord.getEmployee());
//                    return payroll;
//
//                });
//    }

    public void deletePayrollRecordById(Long id) {
        payrollRecordRepository.deleteById(id);
    }



    // method of calculating total of allowance and deductions

}