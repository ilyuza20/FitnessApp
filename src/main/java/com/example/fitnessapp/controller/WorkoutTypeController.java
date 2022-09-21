package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.ExerciseType;
import com.example.fitnessapp.entity.WorkoutType;
import com.example.fitnessapp.service.WorkoutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/{idUser}/workouttypes")
public class WorkoutTypeController {

    private final WorkoutTypeService workoutTypeService;

    @Autowired
    public WorkoutTypeController(WorkoutTypeService workoutTypeService) {
        this.workoutTypeService = workoutTypeService;
    }

    @PostMapping
    public @ResponseBody
    WorkoutType addWorkoutType(@Valid @RequestBody WorkoutType workoutType){
        return workoutTypeService.addWorkoutType(workoutType);
    }

    @GetMapping("/{id}")
    public WorkoutType getWorkoutType(@PathVariable Long id){
        return workoutTypeService.getWorkoutType(id);
    }

    @GetMapping
    public @ResponseBody
    List<WorkoutType> getWorkoutTypes(){
        return workoutTypeService.getWorkoutTypes();
    }

    @PutMapping("/{id}")
    public WorkoutType editWorkoutType(@PathVariable final Long id, @RequestBody WorkoutType workoutType) {
        return workoutTypeService.editWorkoutType(id, workoutType);
    }

    @DeleteMapping("/{id}")
    public WorkoutType deleteWorkoutType(@PathVariable final Long id){
        return workoutTypeService.deleteWorkoutType(id);
    }
}
