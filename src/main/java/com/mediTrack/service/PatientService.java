package com.mediTrack.service;

import org.springframework.stereotype.Service;
import com.mediTrack.module.Patient;
import com.mediTrack.repository.PatientRepository;
import java.util.List;

@Service
public class PatientService{

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public Patient getPatientById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new RuntimeException("Patint not found by id: "+id));
    }

    public List<Patient>  getAllPatients() {
        return repo.findAll();
    }

    public Patient addPatient(Patient patient) {
        if(repo.existsByEmail(patient.getEmail())) {
            throw new RuntimeException(("Patient already exists in the given email"+patient.getEmail()));
        }
        return repo.save(patient);
    }

    public Patient updatePatient(Long id,Patient updated) {
        Patient existing = getPatientById(id);

        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setGender(updated.getGender());
        existing.setAddress(updated.getAddress());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());

        return  repo.save(existing);
    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
}
