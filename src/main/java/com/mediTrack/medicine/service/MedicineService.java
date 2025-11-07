package com.mediTrack.medicine.service;

import org.springframework.stereotype.Service;

import com.mediTrack.medicine.repository.MedicineRepository;
import com.mediTrack.medicine.module.Medicine;
import com.mediTrack.medicine.dto.*;
import com.mediTrack.medicine.mapper.MedicineMapper;

import java.util.List;

@Service
public class MedicineService{

    private final MedicineRepository repo;

    public MedicineService(MedicineRepository repo){
        this.repo = repo;
    }

    public List<MedicineToList> getAllMedicine(){
        return repo.findAll().stream().map(MedicineMapper::toList).toList();
    }

    public MedicineResponeDTO getMedicineById(Long id){
        Medicine medicine = repo.findById(id).orElseThrow(()->
                new RuntimeException("Medicine not found by id: "+id));
        return  MedicineMapper.toResponse(medicine);
    }

    public MedicineResponeDTO addMedicine(MedicineCreateDTO dto){
        Medicine medicine = MedicineMapper.toEntity(dto);
        Medicine saved =  repo.save(medicine);
        return MedicineMapper.toResponse(saved);
    }

    public MedicineResponeDTO updateMedicine(Long id, MedicineUpdateDTO dto){
        Medicine existing = repo.findById(id).orElseThrow(()->
                new RuntimeException("Medicine not found by id: "+id));
        MedicineMapper.updateEntity(dto,existing);
        Medicine saved =  repo.save(existing);
        return MedicineMapper.toResponse(saved);
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