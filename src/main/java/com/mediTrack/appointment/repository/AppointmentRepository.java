package com.mediTrack.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediTrack.appointment.module.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
}