package com.mediTrack.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentToList{

    private Long id;
    private String patientName;
    private String doctorName;
    private String status;
    private String date;
    private String time;

}