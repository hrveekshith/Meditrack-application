package com.mediTrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediTrack.module.Medicine;

public interface MedicineRepository  extends  JpaRepository<Medicine,Long>{
}