package com.example.employee_manager.employee.service;

import com.example.employee_manager.employee.dto.EmployeeCreateDto;
import com.example.employee_manager.employee.dto.EmployeeReadDto;
import com.example.employee_manager.employee.entity.Employee;
import com.example.employee_manager.employee.mapper.EmployeeMapper;
import com.example.employee_manager.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EmployeeMapper mapper;

    public EmployeeReadDto findEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapper.toReadDto(employee);
    }

    public List<EmployeeReadDto> findAllEmployees() {
        return repository.findAll().stream()
                .map(mapper::toReadDto)
                .toList();
    }

    public EmployeeReadDto createEmployee(EmployeeCreateDto createDto) {
        Employee employee = mapper.toEntity(createDto);
        Employee saved = repository.save(employee);
        return mapper.toReadDto(saved);
    }


    public EmployeeReadDto updateEmployee(Long id, EmployeeCreateDto updatedEmployee) {
        Employee updated = repository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setDate_hired(LocalDate.parse(updatedEmployee.getDateHired(), DateTimeFormatter.ISO_LOCAL_DATE));
                    employee.setPosition(updatedEmployee.getPosition());
                    employee.setActive(updatedEmployee.isActive());
                    return employee;
        }).orElseThrow(() -> new RuntimeException("Employee not found"));

        return mapper.toReadDto(updated);
    }

    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        repository.delete(employee);
    }
}
