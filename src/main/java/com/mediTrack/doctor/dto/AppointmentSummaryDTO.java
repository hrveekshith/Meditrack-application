package com.mediTrack.doctor.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentSummaryDTO {
    private Long id;
    private String PatientName;
    private String time;
    private String date;
    private String status;
}