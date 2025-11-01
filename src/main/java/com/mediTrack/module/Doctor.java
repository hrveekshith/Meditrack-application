package com.mediTrack.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import  lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name is required")
    private String name;

    @NotNull(message = "Doctor age is required")
    private Integer age;

    @Email(message = "Doctor email is required")
    private String email;

    @NotBlank(message = "Doctor phone number is required")
    private String phoneNum;

    @NotBlank(message = "Doctor specification is required")
    private String specification;
}