package com.mediTrack.prescription.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionCreateDTO {
    @NotBlank(message = "Medicine dosage is required")
    private String dosage;

    @NotBlank(message = "Medicine intake duration is required")
    private String duration;

    @NotBlank(message = "Medicines are required")
    private List<Long> medicineList;

    @NotBlank(message = "Patient id is required")
    private Long patientId;

    @NotBlank(message = "Doctor id is required")
    private Long doctorId;

    @NotBlank(message = "Appointment id is required")
    private Long appointmentId;
}