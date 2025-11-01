package com.mediTrack.repository;

import com.mediTrack.module.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends  JpaRepository<Appointment,Long>{
}