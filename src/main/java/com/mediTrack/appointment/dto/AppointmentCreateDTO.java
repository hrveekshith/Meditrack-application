package com.mediTrack.appointment.dto;


import jakarta.validation.constraints.*;
import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentCreateDTO{
    @NotNull(message = "Patient id is required")
    private Long patientId;

    @NotNull(message = "Doctor id is required")
    private Long doctorId;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    @NotBlank(message = "Status of appointment is required")
    private String appointmentStatus;

}