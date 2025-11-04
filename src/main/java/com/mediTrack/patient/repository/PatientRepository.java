package com.mediTrack.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediTrack.patient.module.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);
}
