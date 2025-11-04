package com.mediTrack.dto.appointment;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentSummaryDTO {

    private Long id;
    private String doctorName;
    private String time;
    private String date;
    private String status;
}