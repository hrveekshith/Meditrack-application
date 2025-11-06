package com.mediTrack.appointment.service;

import com.mediTrack.appointment.dto.AppointmentCreateDTO;
import com.mediTrack.appointment.dto.AppointmentResponse;
import com.mediTrack.appointment.dto.AppointmentToList;
import com.mediTrack.appointment.dto.AppointmentUpdateDTO;
import com.mediTrack.appointment.mapper.AppointmentMapper;
import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.appointment.repository.AppointmentRepository;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.doctor.repository.DoctorRepository;
import com.mediTrack.patient.module.Patient;
import com.mediTrack.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService{

    private final AppointmentRepository repo;
    private final PatientRepository prepo;
    private final DoctorRepository drepo;

    public AppointmentService(AppointmentRepository arepo,PatientRepository prepo, DoctorRepository drepo) {
        this.repo = arepo;
        this.prepo = prepo;
        this.drepo = drepo;
    }

    public List<AppointmentToList> getAllAppointments() {
        return repo.findAll().stream().map(AppointmentMapper::toList).toList();
    }

    public AppointmentResponse createAppointment(AppointmentCreateDTO dto){
        Patient patient = prepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Patient not found by id "+dto.getPatientId()));
        Doctor doctor = drepo.findById(dto.getDoctorId()).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+dto.getDoctorId()));
        Appointment appointment = AppointmentMapper.toEntity(dto,doctor,patient);
        Appointment saved = repo.save(appointment);
        return AppointmentMapper.toResponse(saved);

    }

    public AppointmentResponse getAppointmntById(Long id){
        Appointment appointment =  repo.findById(id).orElseThrow(()->
                new RuntimeException("Appointment not found by id: "+id));
        return AppointmentMapper.toResponse(appointment);
    }

    public AppointmentResponse updateAppointment(Long id, AppointmentUpdateDTO dto){
        Patient patient = prepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Patient not found by id "+dto.getPatientId()));
        Doctor doctor = drepo.findById(dto.getDoctorId()).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+dto.getDoctorId()));
        Appointment existing = repo.findById(id).orElseThrow(()->
                new RuntimeException("Appointment not found by id "+id));
        AppointmentMapper.updateEntity(dto,existing,patient,doctor);
        Appointment saved = repo.save(existing);
        return AppointmentMapper.toResponse(saved);
    }


    public void deleteById(Long id){
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

}