package com.mediTrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediTrack.module.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long>{
}