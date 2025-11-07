package com.mediTrack.medicine.mapper;

import com.mediTrack.medicine.dto.MedicineCreateDTO;
import com.mediTrack.medicine.dto.MedicineResponeDTO;
import com.mediTrack.medicine.dto.MedicineToList;
import com.mediTrack.medicine.dto.MedicineUpdateDTO;
import com.mediTrack.medicine.module.Medicine;

public class MedicineMapper {

    public static MedicineResponeDTO toResponse(Medicine medicine){
        return MedicineResponeDTO.builder()
                .id(medicine.getId())
                .price(medicine.getPrice())
                .name(medicine.getName())
                .manufacturerName(medicine.getManufacturerName())
                .build();
    }

    public static Medicine toEntity(MedicineCreateDTO dto) {
        return Medicine.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .manufacturerName(dto.getManufacturerName())
                .build();
    }

    public static void  updateEntity(MedicineUpdateDTO dto,Medicine medicine){
        if(dto.getName() != null) medicine.setName(dto.getName());
        if(dto.getPrice() != null) medicine.setPrice(dto.getPrice());
        if(dto.getManufacturerName() != null) medicine.setManufacturerName(dto.getManufacturerName());
    }

    public static MedicineToList toList(Medicine medicine){
        return MedicineToList.builder()
                .name(medicine.getName())
                .price(medicine.getPrice())
                .manufacturerName(medicine.getManufacturerName())
                .id(medicine.getId())
                .build();
    }
}