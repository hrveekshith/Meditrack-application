package com.mediTrack.doctor.mapper;


import com.mediTrack.doctor.dto.*;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.patient.module.Patient;

import java.util.List;

public class DoctorMapper{

    public static DoctorResponseDTO toResponse(Doctor doctor){
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .age(doctor.getAge())
                .phoneNum(doctor.getPhoneNum())
                .appointmentSummaryDTOList(doctor.getAppointmentList() != null ?
                        doctor.getAppointmentList().stream().map(a -> new AppointmentSummaryDTO(
                                a.getId(),
                                a.getPatient().getName(),
                                a.getTime(),
                                a.getDate(),
                                a.getAppointmentStatus()
                        )).toList() : List.of())
                .specification(doctor.getSpecification())
                .build();
    }

    public static Doctor toEntity(DoctorCreateDTO dto){
        return Doctor.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .specification(dto.getSpecification())
                .phoneNum(dto.getPhoneNum())
                .build();
    }

    public static DoctorCreateDTO toDTO(Doctor doctor) {
        return DoctorCreateDTO.builder()
                .name(doctor.getName())
                .age(doctor.getAge())
                .email(doctor.getEmail())
                .specification(doctor.getSpecification())
                .phoneNum(doctor.getPhoneNum())
                .build();
    }

    public static void updateEntity(DoctorUpdateDTO dto, Doctor doctor){
        if(dto.getAge() != null) doctor.setAge(dto.getAge());
        if(dto.getPhoneNum() != null) doctor.setAge(dto.getAge());
        if(dto.getName() != null) doctor.setName(dto.getName());
        if(dto.getEmail() != null) doctor.setEmail(dto.getEmail());
        if(dto.getSpecification() != null) doctor.setSpecification(dto.getSpecification());
    }

    public static DoctorToList toList(Doctor doctor){
        return DoctorToList.builder()
                .id(doctor.getId())
                .doctorName(doctor.getName())
                .age(doctor.getAge())
                .phoneNum(doctor.getPhoneNum())
                .email(doctor.getEmail())
                .build();
    }
}