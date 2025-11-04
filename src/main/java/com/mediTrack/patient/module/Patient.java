package com.mediTrack.patient.module;

import com.mediTrack.module.Appointment;
import com.mediTrack.module.Prescription;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "patients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private Integer age;
    private String gender;
    private String address;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptionList;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointmentList;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Doctor{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

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

        @OneToMany(mappedBy = "doctor")
        private List<Appointment> appointmentList;
    }
}


