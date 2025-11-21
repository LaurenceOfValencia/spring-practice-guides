package com.example.employee_manager.payroll.service;

import com.example.employee_manager.employee.entity.Employee;
import com.example.employee_manager.employee.repository.EmployeeRepository;
import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.dto.component.DeductionDto;
import com.example.employee_manager.payroll.dto.record.PayrollRecordCreateDto;
import com.example.employee_manager.payroll.dto.record.PayrollRecordDto;
import com.example.employee_manager.payroll.dto.summary.EmployeePayrollSummaryDto;
import com.example.employee_manager.payroll.dto.summary.PayrollPeriodSummaryDto;
import com.example.employee_manager.payroll.entity.Allowance;
import com.example.employee_manager.payroll.entity.Deduction;
import com.example.employee_manager.payroll.entity.PayrollPeriod;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import com.example.employee_manager.payroll.mapper.*;
import com.example.employee_manager.payroll.repository.PayrollPeriodRepository;
import com.example.employee_manager.payroll.repository.PayrollRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PayrollRecordService {
    @Autowired
    PayrollPeriodMapper periodMapper;
    @Autowired
    PayrollRecordMapper payrollMapper;
    @Autowired
    PayrollSummaryMapper payrollSummaryMapper;
    @Autowired
    AllowanceMapper allowanceMapper;
    @Autowired
    DeductionMapper deductionMapper;

    @Autowired
    PayrollRecordRepository payrollRecordRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PayrollPeriodRepository periodRepository;

    @Autowired
    AllowanceService allowanceService;

    public PayrollRecordDto createPayrollRecord(PayrollRecordCreateDto createDto) {
        PayrollPeriod period = periodRepository.findById(createDto.getPeriodId()).orElseThrow(
                () -> new NoSuchElementException("No period found for id: " + createDto.getPeriodId())
        );
        Employee employee = employeeRepository.findById(createDto.getEmployeeId()).orElseThrow(
                () -> new NoSuchElementException("No employee found for id: " + createDto.getEmployeeId())
        );
        PayrollRecord created = new PayrollRecord();                                                                    // create new entity
        created.setPeriod(period);
        created.setEmployee(employee);
        created.setGrossPay(createDto.getGrossPay());
        created.setPaymentDate(createDto.getPaymentDate());
        created.setNotes(createDto.getNotes());
        List<Allowance> allowances = createDto.getAllowances().stream().map(dto -> {                        // sets each allowance/deduction to it's
            Allowance allowance = allowanceMapper.toEntity(dto);                                                        // corresponding payroll record
            allowance.setPayrollRecord(created);
            return allowance;
        }).toList();
        List<Deduction> deductions = createDto.getDeductions().stream().map(dto -> {
            Deduction deduction = deductionMapper.toEntity(dto);
            deduction.setPayrollRecord(created);
            return deduction;
        }).toList();
        created.setAllowanceList(allowances);
        created.setDeductionList(deductions);
        BigDecimal netPay = created.getGrossPay()                                                                       // calculate net pay
                .add(calculateTotalAllowances(created.getAllowanceList()))
                .subtract(calculateTotalDeductions(created.getDeductionList()));
        created.setNetPay(netPay);
        PayrollRecordDto dto = payrollMapper.toDto(payrollRecordRepository.save(created));
        dto.setTotalAllowances(calculateTotalAllowances(created.getAllowanceList()));
        dto.setTotalDeductions(calculateTotalDeductions(created.getDeductionList()));
        return dto;
    }

//    public PayrollRecordDto getPayrollRecordById(Long id) {
//        PayrollRecordDto recordDto = payrollMapper.toDto(payrollRecordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No payroll record found for id: " + id)));
//        recordDto.setTotalDeductions(recordDto.getDeductions().stream().map(DeductionDto::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
//        recordDto.setTotalAllowances(recordDto.getAllowances().stream().map(AllowanceDto::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
//        return recordDto;
//    }

    /**
     * [ ] TODO: make the get method return a dto
     */
    public PayrollRecord getPayrollRecordById(Long id) {
//        PayrollRecordDto recordDto = payrollMapper.toDto(payrollRecordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No payroll record found for id: " + id)));
        //        recordDto.setTotalDedductions(recordDto.getDeductions().stream().map(DeductionDto::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
//        recordDto.setTotalAllowances(recordDto.getAllowances().stream().map(AllowanceDto::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        return payrollRecordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No payroll record found for id: " + id));
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

    public PayrollPeriodSummaryDto getPayrollSummaryByPeriod(LocalDate periodStart, LocalDate periodEnd) {
        PayrollPeriod period = periodRepository.findByStartDateAndEndDate(periodStart, periodEnd);
        List<PayrollRecord> records = payrollRecordRepository.findByPeriodId(period.getId());
        return payrollSummaryMapper.toDtoPeriodSummary(period, records);
    }

    /** find by employee **/

    public List<PayrollRecordDto> getPayrollRecordsByEmployee(Long id) {
        return payrollRecordRepository.findByEmployeeId(id)
                .stream()
                .map(payrollMapper::toDto)
                .toList();
    }

    public EmployeePayrollSummaryDto getPayrollSummaryByEmployee(Long id) {
        Employee e = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No employee found for id: " + id));
        return payrollSummaryMapper.toDtoEmployeePayrollSummary(e, payrollRecordRepository.findByEmployeeId(id));
    }


    public PayrollRecord updatePayrollRecord(Long id, PayrollRecord updatedPayrollRecord) {
        PayrollRecord existingRecord =
                payrollRecordRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Record not found for id: " + id));

        // update every property
        existingRecord.setEmployee(updatedPayrollRecord.getEmployee());
        existingRecord.setPeriod(updatedPayrollRecord.getPeriod());
        existingRecord.setGrossPay(updatedPayrollRecord.getGrossPay());

        existingRecord.setNetPay(
                updatedPayrollRecord.getGrossPay()
                        .add(calculateTotalAllowances(updatedPayrollRecord.getAllowanceList()))
                        .subtract(calculateTotalDeductions(updatedPayrollRecord.getDeductionList())));

        existingRecord.setPaymentDate(updatedPayrollRecord.getPaymentDate());
        existingRecord.setNotes(updatedPayrollRecord.getNotes());
        payrollRecordRepository.save(existingRecord);
        return existingRecord;
    }

    public void deletePayrollRecordById(Long id) {
        payrollRecordRepository.deleteById(id);
    }

    /** method of calculating total of allowance and deductions **/
    private BigDecimal calculateTotalDeductions(List<Deduction> deductions) {
        return deductions.stream().map(Deduction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalAllowances(List<Allowance> allowances) {
        return allowances.stream().map(Allowance::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}