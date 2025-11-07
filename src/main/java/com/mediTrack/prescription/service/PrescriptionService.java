package com.mediTrack.prescription.service;

import com.mediTrack.appointment.dto.AppointmentResponse;
import com.mediTrack.appointment.module.Appointment;
import com.mediTrack.appointment.repository.AppointmentRepository;
import com.mediTrack.doctor.module.Doctor;
import com.mediTrack.doctor.repository.DoctorRepository;
import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.medicine.repository.MedicineRepository;
import com.mediTrack.patient.module.Patient;
import com.mediTrack.patient.repository.PatientRepository;
import com.mediTrack.prescription.dto.PrescriptionCreateDTO;
import com.mediTrack.prescription.dto.PrescriptionResponseDTO;
import com.mediTrack.prescription.dto.PrescriptionUpdateDTO;
import com.mediTrack.prescription.mapper.PrescriptionMapper;
import org.springframework.stereotype.Service;
import com.mediTrack.prescription.module.Prescription;
import com.mediTrack.prescription.repository.PrescriptionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionService{

    private final PrescriptionRepository repo;
    private final DoctorRepository drepo;
    private final MedicineRepository mrepo;
    private final PatientRepository prepo;
    private final AppointmentRepository arepo;

    public PrescriptionService(PrescriptionRepository repo, PatientRepository prepo, MedicineRepository mrepo, DoctorRepository drepo, AppointmentRepository arepo){
        this.repo = repo;
        this.drepo = drepo;
        this.prepo = prepo;
        this.mrepo = mrepo;
        this.arepo = arepo;
    }

    public List<Prescription> getAllPrescription(){
        return repo.findAll();
    }

    public PrescriptionResponseDTO getPrescriptionById(Long id){
        Prescription prescription =  repo.findById(id).orElseThrow(()->
                new RuntimeException("Prescription not found by id: "+id));
        return PrescriptionMapper.toResponse(prescription);
    }

    public PrescriptionResponseDTO addPrescription(PrescriptionCreateDTO dto){
        Patient patient = prepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Patient not found by id "+dto.getPatientId()));
        Doctor doctor= drepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+dto.getDoctorId()));
        Appointment appointment = arepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Appointemnt not found by id "+dto.getAppointmentId()));
        List<Long> medicineIds = dto.getMedicineList();
        List<Medicine> medicines = new ArrayList<>();
        for(int i=0;i<medicineIds.size();i++){
            int finalI = i;
            medicines.add(mrepo.findById(medicineIds.get(i)).orElseThrow(()->
                    new RuntimeException("Medicine not found by id "+medicineIds.get(finalI))));
        }
        Prescription prescription = PrescriptionMapper.toEntity(dto, patient, doctor, appointment,medicines);
        Prescription saved = repo.save(prescription);
        return PrescriptionMapper.toResponse(saved);

    }

    public PrescriptionResponseDTO updatePrescription(Long id, PrescriptionUpdateDTO dto){
        Prescription existing = repo.findById(id).orElseThrow(()->
                new RuntimeException("Prescription not found by id "+id));
        Patient patient = prepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Patient not found by id "+dto.getPatientId()));
        Doctor doctor= drepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Doctor not found by id "+dto.getDoctorId()));
        Appointment appointment = arepo.findById(dto.getPatientId()).orElseThrow(()->
                new RuntimeException("Appointemnt not found by id "+dto.getAppointmentId()));
        List<Long> medicineIds = dto.getMedicineList();
        List<Medicine> medicines = new ArrayList<>();
        for(int i=0;i<medicineIds.size();i++){
            int finalI = i;
            medicines.add(mrepo.findById(medicineIds.get(i)).orElseThrow(()->
                    new RuntimeException("Medicine not found by id "+medicineIds.get(finalI))));
        }
        PrescriptionMapper.updateEntiry(dto,existing,patient,doctor,appointment,medicines);
        Prescription saved = repo.save(existing);
        return PrescriptionMapper.toResponse(saved);

    }

    public void deletePrescriptionById(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Prescription not found by id: "+id);
        }
        repo.deleteById(id);
    }

    public  void deleteAllPrescription(){
        repo.deleteAll();
    }
}