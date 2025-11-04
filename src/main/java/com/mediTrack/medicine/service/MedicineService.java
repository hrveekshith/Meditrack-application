package com.mediTrack.medicine.service;

import org.springframework.stereotype.Service;

import com.mediTrack.medicine.repository.MedicineRepository;
import com.mediTrack.medicine.module.Medicine;

import java.util.List;

@Service
public class MedicineService{

    private final MedicineRepository repo;

    public MedicineService(MedicineRepository repo){
        this.repo = repo;
    }

    public List<Medicine> getAllMedicine(){
        return repo.findAll();
    }

    public Medicine getMedicineById(Long id){
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Medicine not found by id: "+id));
    }

    public Medicine addMedicine(Medicine medicine){
        return repo.save(medicine);
    }

    public Medicine updateMedicine(Long id, Medicine medicine){
        Medicine existing = getMedicineById(id);
        existing.setName(medicine.getName());
        existing.setPrice(medicine.getPrice());
        existing.setManufacturerName(medicine.getManufacturerName());
        existing.setPrescriptionList(medicine.getPrescriptionList());
        return repo.save(existing);
    }

    public void deleteMedicineById(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Medicine not found by id: "+id);
        }
        repo.deleteById(id);
    }

    public void deleteAllMedicines(){
        repo.deleteAll();
    }
}