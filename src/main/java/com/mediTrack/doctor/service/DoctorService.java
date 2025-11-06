package com.mediTrack.doctor.service;

import com.mediTrack.doctor.dto.DoctorCreateDTO;
import com.mediTrack.doctor.dto.DoctorResponseDTO;
import com.mediTrack.doctor.dto.DoctorToList;
import com.mediTrack.doctor.dto.DoctorUpdateDTO;
import com.mediTrack.doctor.mapper.DoctorMapper;
import com.mediTrack.doctor.module.Doctor;
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

    public List<DoctorToList> getAllDoctors(){
        return repo.findAll().stream()
                .map(DoctorMapper::toList)
                .toList();
    }

    public DoctorResponseDTO getDoctorById(Long id){
        Doctor doctor = repo.findById(id).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+id));
        return DoctorMapper.toResponse(doctor);

    }

    public DoctorResponseDTO addDoctor(DoctorCreateDTO dto){
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor saved = repo.save(doctor);
        return DoctorMapper.toResponse(saved);
    }

    public DoctorResponseDTO updateDoctor(Long id, DoctorUpdateDTO dto){
        Doctor doctor = repo.findById(id).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+id));
        DoctorMapper.updateEntity(dto,doctor);
        return DoctorMapper.toResponse(repo.save(doctor));
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