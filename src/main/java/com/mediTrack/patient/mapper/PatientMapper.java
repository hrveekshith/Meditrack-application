package com.mediTrack.patient.mapper;

import com.mediTrack.patient.dto.PatientCreateDTO;
import com.mediTrack.patient.module.Patient;

public class PatientMapper{

    public static PatientCreateDTO toDto(Patient patient){
        return PatientCreateDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .age(patient.getAge())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .gender(patient.getGender())
                .phoneNumber(patient.getPhoneNumber())
                .build();
    }

    public static Patient toEntity(PatientCreateDTO patientDTO){
        return Patient.builder()
                .address(patientDTO.getAddress())
                .gender(patientDTO.getGender())
                .phoneNumber(patientDTO.getPhoneNumber())
                .email(patientDTO.getEmail())
                .age(patientDTO.getAge())
                .id(patientDTO.getId())
                .name(patientDTO.getName())
                .build();
    }
}