package com.example.repo;

import com.example.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {

    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);
}
