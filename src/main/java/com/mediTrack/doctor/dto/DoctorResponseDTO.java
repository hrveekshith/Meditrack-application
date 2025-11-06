package com.mediTrack.doctor.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import  lombok.*;

import com.mediTrack.doctor.dto.AppointmentSummaryDTO;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO{

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phoneNum;
    private String specification;
    private List<AppointmentSummaryDTO> appointmentSummaryDTOList;

}