package com.mediTrack.appointment.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO{

    private Long id;
    private String doctorName;
    private String time;
    private String date;
    private String status;
}