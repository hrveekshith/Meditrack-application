package com.mediTrack.prescription.service;

import org.springframework.stereotype.Service;
import com.mediTrack.prescription.module.Prescription;
import com.mediTrack.prescription.repository.PrescriptionRepository;
import java.util.List;

@Service
public class PrescriptionService{

    private final PrescriptionRepository repo;

    public PrescriptionService(PrescriptionRepository repo){
        this.repo = repo;
    }

    public List<Prescription> getAllPrescription(){
        return repo.findAll();
    }

    public Prescription getPrescriptionById(Long id){
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Prescription not found by id: "+id));
    }

    public Prescription addPrescription(Prescription prescription){
        return repo.save(prescription);
    }

    public Prescription updatePrescription(Long id, Prescription prescription){
        Prescription existing = getPrescriptionById(id);
        existing.setDosage(prescription.getDosage());
        existing.setDuration(prescription.getDuration());
        existing.setPatient(prescription.getPatient());
        existing.setMedicineList(prescription.getMedicineList());
        existing.setAppointment(prescription.getAppointment());
        return repo.save(existing);
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