package com.mediTrack.prescription.dto;

import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.patient.module.Patient;
import com.mediTrack.prescription.module.Prescription;

import java.util.List;

public class PrescriptionMapper {

    public static PrescriptionResponseDTO toDto(Prescription prescription){
        return PrescriptionResponseDTO.builder()
                .doctorId(prescription.getDoctor().getId())
                .id(prescription.getId())
                .dosage(prescription.getDosage())
                .appointmentId(prescription.getAppointment().getId())
                .duration(prescription.getDuration())
                .medicineids(prescription.getMedicineList() != null ? prescription.getMedicineList()
                        .stream().map(Medicine::getId).toList() : List.of())
                .patientId(prescription.getPatient().getId())
                .build();

    }

    public static Prescription toEntity(PrescriptionCreateDTO dto, Patient patient, Doctor doctor, Appointment appointment, List<Medicine> medicines){
        return Prescription.builder()
                .patient(patient)
                .doctor(doctor)
                .appointment(appointment)
                .dosage(dto.getDosage())
                .duration(dto.getDuration())
                .medicineList(medicines)
                .appointment(appointment)
                .build();
    }


}