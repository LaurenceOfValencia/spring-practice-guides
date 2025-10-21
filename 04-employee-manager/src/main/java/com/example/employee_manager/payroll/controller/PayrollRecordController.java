package com.example.employee_manager.payroll.controller;

import com.example.employee_manager.payroll.dto.record.PayrollRecordCreateDto;
import com.example.employee_manager.payroll.dto.record.PayrollRecordDto;
import com.example.employee_manager.payroll.entity.PayrollRecord;
import com.example.employee_manager.payroll.mapper.PayrollRecordMapper;
import com.example.employee_manager.payroll.service.PayrollRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollRecordController {

    @Autowired
    private PayrollRecordService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PayrollRecordDto> createPayrollRecord(@RequestBody PayrollRecordCreateDto record) {
        PayrollRecordDto recordDto = service.createPayrollRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollRecord> findRecordById(@PathVariable Long id) {
        PayrollRecord payrollRecord = service.getPayrollRecordById(id);
        return ResponseEntity.ok(payrollRecord);
    }

    @GetMapping("/period")
    public ResponseEntity<List<PayrollRecordDto>> findRecordsByPeriod(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        List<PayrollRecordDto> payrollRecords = service.getPayrollRecordsByPeriod(startDate, endDate);
        return ResponseEntity.ok(payrollRecords);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollRecord> updatePayrollRecord(
            @PathVariable Long id,
            @RequestBody PayrollRecord updatedPayrollRecord
    ) {
        return ResponseEntity.ok(service.updatePayrollRecord(id, updatedPayrollRecord));
    }
}

