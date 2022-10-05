package com.ironhack.Lab_4_04.service;

import com.ironhack.Lab_4_04.dto.PatientDto;
import com.ironhack.Lab_4_04.models.Employee;
import com.ironhack.Lab_4_04.models.Patient;
import com.ironhack.Lab_4_04.repository.EmployeeRepository;
import com.ironhack.Lab_4_04.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;
    private final EmployeeRepository employeeRepository;


    public Patient update(Long patientId, PatientDto dto) {

        Patient patient = repository.findById(patientId).orElseThrow();

        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow();
        patient.setAdmittedBy(employee);
        return repository.save(patient);
    }

    public Patient create(PatientDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow();
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setAdmittedBy(employee);

        return repository.save(patient);
    }

}
