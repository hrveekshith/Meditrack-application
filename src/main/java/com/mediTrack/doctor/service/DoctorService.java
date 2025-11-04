package com.mediTrack.doctor.service;

import com.mediTrack.patient.module.Patient;
import org.springframework.stereotype.Service;
import com.mediTrack.doctor.repository.DoctorRepository;
import java.util.List;

@Service
public class DoctorService{

    private final DoctorRepository repo;

    public DoctorService(DoctorRepository repo){
        this.repo = repo;
    }

    public List<Patient.Doctor> getAllDoctors(){
        return repo.findAll();
    }

    public Patient.Doctor getDoctorById(Long id){
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+id));

    }

    public Patient.Doctor addDoctor(Patient.Doctor doctor){
        return repo.save(doctor);
    }

    public Patient.Doctor updateDoctor(Long id, Patient.Doctor doctor){
        Patient.Doctor existing = getDoctorById(id);
        existing.setAge(doctor.getAge());
        existing.setName(doctor.getName());
        existing.setEmail(doctor.getEmail());
        existing.setSpecification(doctor.getSpecification());
        existing.setAppointmentList(doctor.getAppointmentList());
        return repo.save(existing);
    }

    public void deleteById(Long id){
        if(!repo.existsById(id)) {
            throw new RuntimeException("Doctor not found by id: " + id);
        }
        else repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }
}