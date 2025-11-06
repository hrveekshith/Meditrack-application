package com.mediTrack.doctor.dto;

import com.mediTrack.patient.dto.AppointmentSummaryDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DoctorUpdateDTO {

    private String name;

    @Min(value=28, message = "Doctor age must be greater than or equal to 28")
    private Integer age;

    @Email(message = "Doctor email is required")
    private String email;

    @Size(min=10,max=10,message = "Phone number must to 10 digit long")
    private String phoneNum;

    private String specification;
}