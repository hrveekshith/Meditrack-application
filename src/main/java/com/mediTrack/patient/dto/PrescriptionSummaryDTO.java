package com.mediTrack.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionSummaryDTO {
    private Long id;
    private String dosage;
    private String duration;
    private String doctorName;
    private List<String> medicines;
    private String appointmentDate;

}