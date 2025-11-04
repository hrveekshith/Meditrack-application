package com.mediTrack.prescription.dto;

import lombok.*;

import com.mediTrack.appointment.dto.AppointmentDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionSummaryDTO {

    private Long id;
    private String dosage;
    private String duration;
    private List<String> medicines;
    private AppointmentDTO appointment;

}