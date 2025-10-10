package com.example.employee_manager.payroll.repository;

import com.example.employee_manager.payroll.entity.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DeductionRepository extends JpaRepository<Deduction, Long> {
    List<Deduction> findByPayrollRecordId(Long payrollRecordId);
}
