package com.mediTrack.patient.controller;

import com.mediTrack.patient.dto.PatientCreateDTO;
import com.mediTrack.patient.dto.PatientListDTO;
import com.mediTrack.patient.dto.PatientResponseDTO;
import com.mediTrack.patient.dto.PatientUpdateDTO;
import jakarta.validation.Valid;
import com.mediTrack.patient.module.Patient;
import com.mediTrack.patient.service.PatientService;
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
    public List<PatientListDTO> getAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientResponseDTO getById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(@Valid @RequestBody PatientCreateDTO patient) {
        return ResponseEntity.ok(service.addPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable Long id, @RequestBody PatientUpdateDTO patient) {
        return ResponseEntity.ok(service.updatePatient(id,patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}

