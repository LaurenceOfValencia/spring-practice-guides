package com.example.employee_manager.employee.mapper;

import com.example.employee_manager.employee.dto.EmployeeCreateDto;
import com.example.employee_manager.employee.dto.EmployeeReadDto;
import com.example.employee_manager.employee.entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EmployeeMapper {

    public EmployeeReadDto toReadDto(Employee entity) {
        EmployeeReadDto dto = new EmployeeReadDto();
        dto.setName(entity.getName());
        dto.setPosition(entity.getPosition());
        return dto;
    }

    public Employee toEntity(EmployeeCreateDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setPosition(dto.getPosition());
        employee.setDate_hired(LocalDate.parse(dto.getDateHired(), DateTimeFormatter.ISO_LOCAL_DATE));
        employee.setPosition(dto.getPosition());
        employee.setActive(dto.isActive());
        return employee;
    }

}
