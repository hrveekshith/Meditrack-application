package com.mediTrack.prescription.mapper;

import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.patient.module.Patient;
import com.mediTrack.prescription.dto.*;
import com.mediTrack.prescription.module.Prescription;


import javax.print.Doc;
import java.util.List;

public class PrescriptionMapper {

    public static PrescriptionResponseDTO toResponse(Prescription prescription){
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

    public static PrescriptionToList toList(Prescription prescription){
        return PrescriptionToList.builder()
                .doctorName(prescription.getDoctor().getName())
                .patientName(prescription.getPatient().getName())
                .medicines(prescription.getMedicineList() != null ? prescription.getMedicineList()
                        .stream().map(Medicine::getName).toList() : List.of())
                .build();
    }

    public static void updateEntiry(PrescriptionUpdateDTO dto, Prescription prescription, Patient patient, Doctor doctor,Appointment appointment, List<Medicine> medicines) {
        if(dto.getDoctorId() != null) prescription.setDoctor(doctor);
        if(dto.getPatientId() != null) prescription.setPatient(patient);
        if(dto.getDosage() != null) prescription.setDosage(dto.getDosage());
        if(dto.getDuration() != null) prescription.setDuration(dto.getDuration());
        if(dto.getMedicineList() != null) prescription.setMedicineList(medicines);
        if(dto.getAppointmentId() != null) prescription.setAppointment(appointment);
    }


}