package com.mediTrack.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentUpdateDTO{
    private Long patientId;
    private Long doctorId;
    private String time;
    private String date;
    private String appointmentStatus;
}