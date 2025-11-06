package com.mediTrack.appointment.mapper;

import com.mediTrack.appointment.dto.*;
import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.patient.module.Patient;

public class AppointmentMapper{

    public static AppointmentResponse toResponse(Appointment appointment){
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .patientSummaryDTO(new PatientSummaryDTO(
                        appointment.getPatient().getId(),
                        appointment.getPatient().getName(),
                        appointment.getPatient().getEmail(),
                        appointment.getPatient().getPhoneNumber(),
                        appointment.getPatient().getAge(),
                        appointment.getPatient().getGender()))
                .doctorSummaryDTO(DoctorSummaryDTO.builder()
                        .name(appointment.getDoctor().getName())
                        .email(appointment.getDoctor().getEmail())
                        .age(appointment.getDoctor().getAge())
                        .specification(appointment.getDoctor().getSpecification())
                        .id(appointment.getDoctor().getId())
                        .phoneNum(appointment.getDoctor().getPhoneNum())
                        .build())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .applicationStatus(appointment.getAppointmentStatus())
                .build();
    }

    public static Appointment toEntity(AppointmentCreateDTO dto, Doctor doctor, Patient patient) {
        return  Appointment.builder()
                .date(dto.getDate())
                .time(dto.getTime())
                .appointmentStatus(dto.getAppointmentStatus())
                .patient(patient)
                .doctor(doctor)
                .build();
    }

    public static AppointmentToList toList(Appointment appointment){
        return AppointmentToList.builder()
                .id(appointment.getId())
                .time(appointment.getTime())
                .date(appointment.getDate())
                .status(appointment.getAppointmentStatus())
                .patientName(appointment.getPatient().getName())
                .doctorName(appointment.getDoctor().getName())
                .build();
    }

    public static void updateEntity(AppointmentUpdateDTO dto,Appointment appointment,Patient patient,Doctor doctor){
        if(dto.getPatientId() != null) appointment.setPatient(patient);
        if(dto.getDoctorId() != null) appointment.setDoctor(doctor);
        if(dto.getTime() != null) appointment.setTime(dto.getTime());
        if(dto.getDate() != null) appointment.setDate(dto.getDate());
        if(dto.getAppointmentStatus() != null) appointment.setAppointmentStatus(dto.getAppointmentStatus());

    }
}