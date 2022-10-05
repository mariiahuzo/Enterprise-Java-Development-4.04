package com.ironhack.Lab_4_04.controller;

import com.ironhack.Lab_4_04.dto.PatientDto;
import com.ironhack.Lab_4_04.models.Patient;
import com.ironhack.Lab_4_04.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PatientDto dto) {
        service.create(dto);

    }


    @PutMapping("/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@PathVariable(name = "patientId") Long id, @Valid @RequestBody PatientDto dto) {
        return service.update(id, dto);

    }

}
