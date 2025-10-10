package com.example.employee_manager.employee.controller;

import com.example.employee_manager.employee.dto.EmployeeCreateDto;
import com.example.employee_manager.employee.dto.EmployeeReadDto;
import com.example.employee_manager.employee.entity.Employee;
import com.example.employee_manager.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeReadDto> createEmployee(@RequestBody EmployeeCreateDto createDto) {
        EmployeeReadDto savedEmployee = service.createEmployee(createDto);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeReadDto>> findAll() {
        List<EmployeeReadDto> employees = service.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeReadDto> getEmployeeById(@PathVariable Long id) {
        EmployeeReadDto employee = service.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * Using EmployeeCreateDto to update existing employee records
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeReadDto> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeCreateDto updateDto) {
        EmployeeReadDto updatedEmployee = service.updateEmployee(id, updateDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // returns HTTP 204
    }
}
