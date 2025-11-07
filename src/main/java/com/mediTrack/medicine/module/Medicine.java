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
@Builder
public class Medicine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String manufacturerName;

    private Float price;

    @ManyToMany(mappedBy = "medicineList",cascade = CascadeType.ALL)
    private List<Prescription> prescriptionList;

}