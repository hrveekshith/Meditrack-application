package com.mediTrack.appointment.module;

import com.mediTrack.prescription.module.Prescription;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import com.mediTrack.patient.module.Patient;
import com.mediTrack.doctor.module.Doctor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String date;
    private String time;
    private String appointmentStatus;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Prescription prescription;
}