package com.ironhack.Lab_4_04.repository;

import com.ironhack.Lab_4_04.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
