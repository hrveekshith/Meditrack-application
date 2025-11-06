package com.mediTrack.patient.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientUpdateDTO{

    private String name;


    @Size(min=10,max=10,message = "Phone number must be 10 digits long")
    private String phoneNumber;


    private String email;

    @Min(value = 0, message= "Age must not be negitive")
    private Integer age;

    private String gender;
    private String address;

}
