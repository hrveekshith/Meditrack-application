package com.mediTrack.doctor.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorToList{

    private Long id;
    private String doctorName;
    private Integer age;
    private String email;
    private String phoneNum;
}