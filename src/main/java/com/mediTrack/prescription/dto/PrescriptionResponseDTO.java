package com.mediTrack.prescription.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionResponseDTO{
    private Long id;
    private String dosage;
    private String duration;
    private List<Long> medicineids;
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
}