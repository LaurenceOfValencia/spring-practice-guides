package com.example.employee_manager.payroll.service;

import com.example.employee_manager.payroll.dto.component.AllowanceDto;
import com.example.employee_manager.payroll.entity.Allowance;
import com.example.employee_manager.payroll.mapper.AllowanceMapper;
import com.example.employee_manager.payroll.repository.AllowanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllowanceService {

    @Autowired
    private AllowanceRepository repository;
    @Autowired
    private AllowanceMapper mapper;

    public void create(AllowanceDto allowance) {
        Allowance entity = mapper.toEntity(allowance);
        repository.save(entity);
    }

    public List<AllowanceDto> getByPayroll(long payrollId) {
        if (repository.findByPayrollRecord_Id(payrollId).isEmpty()) {
            return null;
        }
        return repository.findByPayrollRecord_Id(payrollId).stream().map(mapper::toDto).toList();
    }
}
