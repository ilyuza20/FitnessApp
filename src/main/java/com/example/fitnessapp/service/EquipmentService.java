package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.Equipment;
import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository, UserService userService) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getEquipments(){
        return equipmentRepository.findAll();
    }

    public Equipment getEquipment(Long id){
        return equipmentRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
    }

    public Equipment deleteEquipment(Long id) {
        Equipment equipment = getEquipment(id);
        equipmentRepository.delete(equipment);
        return equipment;
    }

    public Equipment editEquipment(Long id, Equipment equipment){
        Equipment editEquipment = getEquipment(id);
        editEquipment.setName(equipment.getName());
        equipmentRepository.save(editEquipment);
        return editEquipment;
    }
}
