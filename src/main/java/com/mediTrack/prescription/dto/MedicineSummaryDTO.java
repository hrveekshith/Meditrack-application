package com.mediTrack.prescription.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineSummaryDTO {
    private Long id;
    private String name;
    private String manufacturerName;
    private float price;

}