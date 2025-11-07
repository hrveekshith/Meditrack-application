package com.mediTrack.medicine.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineCreateDTO {

    @NotBlank(message = "Medicine name is required")
    private String name;

    @NotBlank(message = "Manufaturer name is required")
    private String manufacturerName;

    @NotNull(message = "Medicine price is required")
    private Float price;
}