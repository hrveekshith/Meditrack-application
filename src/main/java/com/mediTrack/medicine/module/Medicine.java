package com.mediTrack.medicine.module;

import com.mediTrack.prescription.module.Prescription;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "medicines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Medicine name is required")
    private String name;

    @NotBlank(message = "Manufaturer name is required")
    private String manufacturerName;

    @NotNull(message = "Medicine price is required")
    private float price;

    @OneToMany(mappedBy = "medicine",cascade = CascadeType.ALL)
    private List<Prescription> prescriptionList;

}