package com.mediTrack.appointment.dto;

import com.mediTrack.appointment.dto.PatientSummaryDTO;
import com.mediTrack.appointment.dto.DoctorSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppointmentResponse {

    private Long id;
    private PatientSummaryDTO patientSummaryDTO;
    private DoctorSummaryDTO doctorSummaryDTO;
    private String date;
    private String time;
    private String applicationStatus;

}