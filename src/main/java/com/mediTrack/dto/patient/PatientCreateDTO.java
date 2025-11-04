package com.mediTrack.dto.patient;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientCreateDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Size(min=10,max=10,message = "Phone number must be 10 digits long")
    private String phoneNumber;

    @Email(message = "Invalid email format!")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 0,message = "Age cannot be negative")
    private Integer age;

    private String gender;
    private String address;

}


