package com.example.employee_manager.payroll.repository;

import com.example.employee_manager.payroll.entity.PayrollRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PayrollRecordRepository extends JpaRepository<PayrollRecord, Long> {
    // Find payroll records by employee ID
    List<PayrollRecord> findByEmployeeId(Long employeeId);

    // Find payroll records by period ID
    List<PayrollRecord> findByPeriodId(Long periodId);

    // Find payroll records between payment dates
    List<PayrollRecord> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);

    // Find records for specific employee within a date range
    List<PayrollRecord> findByEmployeeIdAndPaymentDateBetween(
            Long employeeId, LocalDate startDate, LocalDate endDate);

    // Find most recent payroll record for an employee
    Optional<PayrollRecord> findTopByEmployeeIdOrderByPaymentDateDesc(Long employeeId);


}
