package com.mediTrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.mediTrack.module.Appointment;
import com.mediTrack.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController{

    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    @GetMapping
    public List<Appointment> getAll(){
        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getAppointmntById(id));
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@Valid @RequestBody Appointment appointment){
        return ResponseEntity.ok(service.createAppointment(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment){
        return ResponseEntity.ok(service.updateAppointment(id,appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok("Appointment "+id+" deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        service.deleteAll();
        return ResponseEntity.ok("All appointments deleted successfully");
    }

}