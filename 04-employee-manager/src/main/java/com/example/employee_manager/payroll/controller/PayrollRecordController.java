package com.example.employee_manager.payroll.controller;

import com.example.employee_manager.payroll.dto.record.PayrollRecordDto;
import com.example.employee_manager.payroll.service.PayrollRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollRecordController {

    @Autowired
    private PayrollRecordService service;

    @GetMapping("/period-summary")
    public ResponseEntity<List<PayrollRecordDto>> findRecordsByPeriod(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        List<PayrollRecordDto> payrollRecords = service.getPayrollRecordsByPeriod(startDate, endDate);
        return ResponseEntity.ok(payrollRecords);
    }
}

