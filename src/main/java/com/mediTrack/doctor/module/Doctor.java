package com.mediTrack.doctor.module;

import com.mediTrack.appointment.module.Appointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import  lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @Size(min=10,max=10,message = "Phone number must to 10 digit long")
    private String phoneNum;

    private String specification;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;
}