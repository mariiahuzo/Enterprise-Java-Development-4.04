package com.ironhack.Lab_4_04.controller;

import com.ironhack.Lab_4_04.dto.EmployeeDto;
import com.ironhack.Lab_4_04.models.Employee;
import com.ironhack.Lab_4_04.models.EmployeeStatus;
import com.ironhack.Lab_4_04.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody EmployeeDto employee) {

        service.createEmployee(employee);

    }

    @PatchMapping("/{employeeId}/status")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateStatus(@PathVariable(name = "employeeId") Long employeeId, @RequestParam EmployeeStatus status) {
        return service.updateEmployeeStatus(employeeId, status);

    }

    @PatchMapping("/{employeeId}/department")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateDepartment(@PathVariable(name = "employeeId") Long employeeId, @RequestParam String department) {
        return service.updateEmployeeDepartment(employeeId, department);

    }
}
