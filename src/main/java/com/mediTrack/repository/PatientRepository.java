package com.mediTrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediTrack.module.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);
}
