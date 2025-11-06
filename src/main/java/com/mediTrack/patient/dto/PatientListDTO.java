package com.mediTrack.patient.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientListDTO{

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}