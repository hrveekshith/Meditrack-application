package com.mediTrack.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediTrack.medicine.module.Medicine;

public interface MedicineRepository  extends  JpaRepository<Medicine,Long>{
}