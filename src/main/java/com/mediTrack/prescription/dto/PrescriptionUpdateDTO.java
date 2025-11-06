package com.mediTrack.prescription.dto;


import java.util.List;

public class PrescriptionUpdateDTO {

    private String dosage;
    private String duration;
    private List<Long> medicineList;
    private Long patientId;
    private Long doctorId;
}