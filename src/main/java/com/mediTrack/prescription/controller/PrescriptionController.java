package com.mediTrack.prescription.controller;

import com.mediTrack.prescription.dto.PrescriptionCreateDTO;
import com.mediTrack.prescription.dto.PrescriptionResponseDTO;
import com.mediTrack.prescription.dto.PrescriptionToList;
import com.mediTrack.prescription.dto.PrescriptionUpdateDTO;
import com.mediTrack.prescription.mapper.PrescriptionMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.mediTrack.prescription.module.Prescription;
import com.mediTrack.prescription.service.PrescriptionService;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service){
        this.service = service;
    }

    @GetMapping
    public List<PrescriptionToList> getAll(){
        return service.getAllPrescription().stream().map(PrescriptionMapper::toList).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPrescriptionById(id));
    }

    @PostMapping
    public ResponseEntity<PrescriptionResponseDTO> create(@Valid @RequestBody PrescriptionCreateDTO prescription) {
        return ResponseEntity.ok(service.addPrescription(prescription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PrescriptionUpdateDTO prescription) {
        return ResponseEntity.ok(service.updatePrescription(id,prescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deletePrescriptionById(id);
        return ResponseEntity.ok("Prescription "+id+" deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        service.deleteAllPrescription();
        return ResponseEntity.ok("All Prescriptions deleted successfully");
    }


}