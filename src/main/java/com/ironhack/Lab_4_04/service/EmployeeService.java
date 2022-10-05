package com.ironhack.Lab_4_04.service;

import com.ironhack.Lab_4_04.dto.EmployeeDto;
import com.ironhack.Lab_4_04.models.Employee;
import com.ironhack.Lab_4_04.models.EmployeeStatus;
import com.ironhack.Lab_4_04.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public void createEmployee(EmployeeDto dto) {

        Employee model = new Employee();
        model.setName(dto.getName());
        model.setStatus(dto.getStatus());
        model.setDepartment(dto.getDepartment());
        model.setPatients(List.of());

        repository.save(model);


    }

    public Employee updateEmployeeStatus(Long employeeId, EmployeeStatus status) {
        Employee employee = repository.findById(employeeId).orElseThrow();
        employee.setStatus(status);
        return repository.save(employee);
    }

    public Employee updateEmployeeDepartment(Long employeeId, String department) {
        Employee employee = repository.findById(employeeId).orElseThrow();
        employee.setDepartment(department);
        return repository.save(employee);
    }

}
