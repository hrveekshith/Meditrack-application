package com.mediTrack.doctor.controller;

import com.mediTrack.doctor.dto.DoctorCreateDTO;
import com.mediTrack.doctor.dto.DoctorResponseDTO;
import com.mediTrack.doctor.dto.DoctorToList;
import com.mediTrack.doctor.dto.DoctorUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.mediTrack.doctor.service.DoctorService;


import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController{

    private final DoctorService service;

    public DoctorController(DoctorService service){
        this.service = service;
    }

    @GetMapping
    public List<DoctorToList> getAllDoctors(){
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> create(@Valid @RequestBody DoctorCreateDTO doctor){
        return ResponseEntity.ok(service.addDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody DoctorUpdateDTO doctor){
        return ResponseEntity.ok(service.updateDoctor(id,doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Doctor "+id+" deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        service.deleteAll();
        return ResponseEntity.ok("Deleted all doctors successfully");
    }
}