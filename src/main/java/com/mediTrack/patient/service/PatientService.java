package com.mediTrack.patient.service;

import org.springframework.stereotype.Service;

import com.mediTrack.patient.module.Patient;
import com.mediTrack.patient.repository.PatientRepository;
import com.mediTrack.patient.dto.*;
import com.mediTrack.patient.mapper.PatientMapper;

import java.util.List;

@Service
public class PatientService{

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = repo.findById(id).orElseThrow(()->
                new RuntimeException("Patient not found by id "+id));
        PatientResponseDTO patientResponseDTO = PatientMapper.toResponse(patient);
        return patientResponseDTO;
    }

    public List<PatientListDTO>  getAllPatients() {
        return repo.findAll()
                .stream()
                .map(PatientMapper::toList)
                .toList();
    }

    public PatientResponseDTO addPatient(PatientCreateDTO dto) {
        Patient patient = PatientMapper.toEntity(dto);
        if(repo.existsByEmail(patient.getEmail())) {
            throw new RuntimeException(("Patient already exists in the given email"+dto.getEmail()));
        }
        Patient saved = repo.save(patient);
        return PatientMapper.toResponse(saved);
    }

    public PatientResponseDTO updatePatient(Long id,PatientUpdateDTO dto) {
        Patient existing = repo.findById(id)
                .orElseThrow(()->new RuntimeException("Patient not found by id "+id));

        PatientMapper.updateEntity(dto,existing);
        Patient updated = repo.save(existing);
        return PatientMapper.toResponse(updated);

    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }

    public void deleteAll(Long id) { repo.deleteAll(); }
}
