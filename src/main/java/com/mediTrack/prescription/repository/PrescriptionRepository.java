package com.mediTrack.prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediTrack.prescription.module.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long>{
}