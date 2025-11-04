package com.mediTrack.dto.prescription;

import lombok.*;

import com.mediTrack.dto.appointment.AppointmentDTO;

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