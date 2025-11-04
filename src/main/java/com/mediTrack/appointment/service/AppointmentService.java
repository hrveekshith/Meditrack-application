package com.mediTrack.appointment.service;

import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService{

    private final AppointmentRepository repo;

    public AppointmentService(AppointmentRepository repo) {
        this.repo = repo;
    }

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public Appointment createAppointment(Appointment appointment){
        return repo.save(appointment);
    }

    public Appointment getAppointmntById(Long id){
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Appointment not found by id: "+id));
    }

    public Appointment updateAppointment(Long id,Appointment updated){
        Appointment existing = getAppointmntById(id);
        existing.setPatient(updated.getPatient());
        existing.setDoctor(updated.getDoctor());
        existing.setTime(updated.getTime());
        existing.setDate(updated.getDate());
        existing.setAppointmentStatus(updated.getAppointmentStatus());
        return repo.save(existing);
    }


    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

}