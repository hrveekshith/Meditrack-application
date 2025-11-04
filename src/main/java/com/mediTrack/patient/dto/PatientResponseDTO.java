package com.mediTrack.patient.dto;

import lombok.*;

import com.mediTrack.appointment.dto.AppointmentSummaryDTO;
import com.mediTrack.prescription.dto.PrescriptionSummaryDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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