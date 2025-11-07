package com.mediTrack.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineResponeDTO {
    private Long id;
    private String name;
    private String manufacturerName;
    private float price;
}