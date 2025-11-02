package com.mediTrack.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mediTrack.module.Medicine;
import com.mediTrack.service.MedicineService;

import java.rmi.server.RemoteRef;
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
    public List<Medicine> getAll(){
        return service.getAllMedicine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getMedicineById(id));
    }

    @PostMapping
    public ResponseEntity<Medicine> create(@Valid @RequestBody Medicine medicine){
        return ResponseEntity.ok(service.addMedicine(medicine));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Long id,@Valid @RequestBody Medicine medicine){
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