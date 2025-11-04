package com.mediTrack.controller;

import com.mediTrack.patient.module.Patient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.mediTrack.service.DoctorService;

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
    public List<Patient.Doctor> getAllDoctors(){
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient.Doctor> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<Patient.Doctor> create(@Valid @RequestBody Patient.Doctor doctor){
        return ResponseEntity.ok(service.addDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient.Doctor> update(@PathVariable Long id, @Valid @RequestBody Patient.Doctor doctor){
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