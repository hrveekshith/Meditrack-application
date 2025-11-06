package com.mediTrack.doctor.dto;

import com.mediTrack.patient.dto.AppointmentSummaryDTO;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorCreateDTO{

    @NotBlank(message = "Doctor name is required")
    private String name;

    @NotNull(message = "Doctor age is required")
    private Integer age;

    @Email(message = "Doctor email is required")
    private String email;

    @NotBlank(message = "Doctor phone number is required")
    @Size(min=10,max=10,message = "Phone number must to 10 digit long")
    private String phoneNum;

    @NotBlank(message = "Doctor specification is required")
    private String specification;

}