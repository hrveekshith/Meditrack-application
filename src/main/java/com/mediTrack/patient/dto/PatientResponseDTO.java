package com.mediTrack.patient.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDTO{

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer age;
    private String gender;
    private String address;
    private List<PrescriptionSummaryDTO> prescriptionList;
    private List<AppointmentSummaryDTO> appointmentList;


}