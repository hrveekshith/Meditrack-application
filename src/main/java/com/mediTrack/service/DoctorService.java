package com.mediTrack.service;

import org.springframework.stereotype.Service;
import com.mediTrack.module.Doctor;
import com.mediTrack.repository.DoctorRepository;
import java.util.List;

@Service
public class DoctorService{

    private final DoctorRepository repo;

    public DoctorService(DoctorRepository repo){
        this.repo = repo;
    }

    public List<Doctor> getAllDoctors(){
        return repo.findAll();
    }

    public Doctor getDoctorById(Long id){
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+id));

    }

    public Doctor addDoctor(Doctor doctor){
        return repo.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor){
        Doctor existing = getDoctorById(id);
        existing.setAge(doctor.getAge());
        existing.setName(doctor.getName());
        existing.setEmail(doctor.getEmail());
        existing.setSpecification(doctor.getSpecification());
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