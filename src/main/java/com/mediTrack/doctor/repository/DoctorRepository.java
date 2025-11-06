package com.mediTrack.doctor.repository;

import com.mediTrack.doctor.module.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor,Long>{
}