package com.mediTrack.appointment.repository;

import com.mediTrack.appointment.module.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends  JpaRepository<Appointment,Long>{
}