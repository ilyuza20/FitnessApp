package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.Equipment;
import com.example.fitnessapp.entity.ExerciseType;
import com.example.fitnessapp.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/{idUser}/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public @ResponseBody
    Equipment addEquipment(@Valid @RequestBody Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }

    @GetMapping
    public @ResponseBody
    List<Equipment> getEquipments(){
        return equipmentService.getEquipments();
    }

    @GetMapping("/{id}")
    public Equipment getEquipment(@PathVariable Long id){
        return equipmentService.getEquipment(id);
    }

    @PutMapping("/{id}")
    public Equipment editEquipment(@PathVariable final Long id, @RequestBody Equipment equipment) {
        return equipmentService.editEquipment(id, equipment);
    }

    @DeleteMapping("/{id}")
    public Equipment deleteEquipment(@PathVariable final Long id){
        return equipmentService.deleteEquipment(id);
    }
}
