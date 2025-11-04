package com.mediTrack.repository;

import com.mediTrack.patient.module.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Patient.Doctor,Long>{
}