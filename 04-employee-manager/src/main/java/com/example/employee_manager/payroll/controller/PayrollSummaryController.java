package com.example.employee_manager.payroll.controller;

import com.example.employee_manager.payroll.dto.summary.EmployeePayrollSummaryDto;
import com.example.employee_manager.payroll.dto.summary.PayrollPeriodSummaryDto;
import com.example.employee_manager.payroll.service.PayrollRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/payroll-summary")
public class PayrollSummaryController {

    @Autowired
    PayrollRecordService service;

    @GetMapping("/period")
    public ResponseEntity<PayrollPeriodSummaryDto> summarizeByPeriod(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        return ResponseEntity.ok(service.getPayrollSummaryByPeriod(startDate, endDate));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeePayrollSummaryDto> summarizeByEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPayrollSummaryByEmployee(id));
    }
    
}
