package com.mediTrack.module;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Size(min=10,max=10,message = "Phone number must be 10 digits long")
    private String phoneNumber;

    @Email(message = "Invalid email format!")
    private String email;

    @NotNull(message = "Age is required")
    @Min(0)
    private Integer age;

    private String gender;
    private String address;

}


