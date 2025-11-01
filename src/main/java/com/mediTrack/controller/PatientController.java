package com.mediTrack.controller;

import jakarta.validation.Valid;
import com.mediTrack.module.Patient;
import com.mediTrack.service.PatientService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@CrossOrigin(origins="*")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Patient> getAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public ResponseEntity<Patient> create(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(service.addPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(service.updatePatient(id,patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}

