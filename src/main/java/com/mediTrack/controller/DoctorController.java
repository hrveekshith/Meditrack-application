package com.mediTrack.controller;

import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.mediTrack.service.DoctorService;
import com.mediTrack.module.Doctor;
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
    public List<Doctor> getAllDoctors(){
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@Valid @RequestBody Doctor doctor){
        return ResponseEntity.ok(service.addDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id,@Valid @RequestBody Doctor doctor){
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