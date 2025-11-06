package com.mediTrack.patient.mapper;


import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.patient.dto.*;
import com.mediTrack.patient.module.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static Patient toEntity(PatientCreateDTO patientCreateDTO) {
        return Patient.builder()
                .name(patientCreateDTO.getName())
                .email(patientCreateDTO.getEmail())
                .address(patientCreateDTO.getAddress())
                .gender(patientCreateDTO.getGender())
                .phoneNumber(patientCreateDTO.getPhoneNumber())
                .age(patientCreateDTO.getAge())
                .build();
    }

    public static void updateEntity(PatientUpdateDTO dto, Patient patient){
        if(dto.getName() != null) patient.setName(dto.getName());
        if(dto.getAddress() != null) patient.setAddress(dto.getAddress());
        if(dto.getAge()!= null) patient.setAge(dto.getAge());
        if(dto.getGender() != null) patient.setGender(dto.getGender());
        if(dto.getEmail() != null) patient.setEmail(dto.getEmail());
        if(dto.getPhoneNumber() != null) patient.setPhoneNumber(dto.getPhoneNumber());
    }

    public static PatientListDTO toList(Patient patient){
        return PatientListDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .build();
    }

    public static PatientResponseDTO toResponse(Patient patient){
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .gender(patient.getGender())
                .prescriptionList(patient.getPrescriptionList() != null ?
                        patient.getPrescriptionList().stream().map(a -> new PrescriptionSummaryDTO(
                                a.getId(),
                                a.getDosage(),
                                a.getDuration(),
                                a.getDoctor().getName(),
                                a.getMedicineList().stream().map(Medicine::getName)
                                        .collect(Collectors.toList()),
                                a.getAppointment().getDate())).toList() : List.of())
                .appointmentList(patient.getAppointmentList() != null ?
                        patient.getAppointmentList().stream().map(a ->new AppointmentSummaryDTO(
                                a.getId(),
                                a.getDoctor().getName(),
                                a.getTime(),
                                a.getDate(),
                                a.getAppointmentStatus())).toList() : List.of())
                .build();
    }
}