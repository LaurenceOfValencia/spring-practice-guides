package com.example.employee_manager.payroll.repository;

import com.example.employee_manager.payroll.entity.PayrollPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PayrollPeriodRepository extends JpaRepository<PayrollPeriod, Long> {

    List<PayrollPeriod> findByStatus(PayrollPeriod.Status status);

    PayrollPeriod findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
