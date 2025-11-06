package com.mediTrack.appointment.controller;

import com.mediTrack.appointment.dto.AppointmentCreateDTO;
import com.mediTrack.appointment.dto.AppointmentResponse;
import com.mediTrack.appointment.dto.AppointmentToList;
import com.mediTrack.appointment.dto.AppointmentUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.appointment.service.AppointmentService;

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
    public List<AppointmentToList> getAll(){
        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getAppointmntById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> create(@Valid @RequestBody AppointmentCreateDTO appointment){
        return ResponseEntity.ok(service.createAppointment(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> update(@PathVariable Long id, @RequestBody AppointmentUpdateDTO appointment){
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