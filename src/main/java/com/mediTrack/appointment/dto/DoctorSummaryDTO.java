package com.mediTrack.appointment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class DoctorSummaryDTO {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phoneNum;
    private String specification;
}