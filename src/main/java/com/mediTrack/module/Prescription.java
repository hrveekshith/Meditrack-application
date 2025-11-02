package com.mediTrack.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "prescriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Medicine dosage is required")
    private String dosage;

    @NotBlank(message = "Medicine intake duration is required")
    private String duration;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private  Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
