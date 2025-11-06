package com.mediTrack.prescription.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentSummaryDTO {
    private Long id;
    private String patientName;
    private String doctorName;
    private String time;
    private String date;
    private String status;
}