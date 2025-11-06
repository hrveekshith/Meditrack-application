package com.mediTrack.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class PatientSummaryDTO{

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer age;
    private String gender;
}