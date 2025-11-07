package com.mediTrack.prescription.module;

import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.patient.module.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "prescriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dosage;
    private String duration;

    @ManyToMany
    @JoinTable(
            name = "prescription_medicine",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private List<Medicine> medicineList;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
