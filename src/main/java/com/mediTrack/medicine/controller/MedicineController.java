package com.mediTrack.medicine.controller;

import com.mediTrack.medicine.dto.MedicineCreateDTO;
import com.mediTrack.medicine.dto.MedicineResponeDTO;
import com.mediTrack.medicine.dto.MedicineToList;
import com.mediTrack.medicine.dto.MedicineUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.medicine.service.MedicineService;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@CrossOrigin(origins = "*")
public class MedicineController{

    private final MedicineService service;

    public MedicineController(MedicineService service){
        this.service = service;
    }

    @GetMapping
    public List<MedicineToList> getAll(){
        return service.getAllMedicine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineResponeDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getMedicineById(id));
    }

    @PostMapping
    public ResponseEntity<MedicineResponeDTO> create(@Valid @RequestBody MedicineCreateDTO medicine){
        return ResponseEntity.ok(service.addMedicine(medicine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineResponeDTO> update(@PathVariable Long id,@Valid @RequestBody MedicineUpdateDTO medicine){
        return ResponseEntity.ok(service.updateMedicine(id,medicine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable  Long id){
        service.deleteMedicineById(id);
        return ResponseEntity.ok("Medicine "+id+" removed successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        service.deleteAllMedicines();
        return ResponseEntity.ok("All medicines removed successfully");
    }
}