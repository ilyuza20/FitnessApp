package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.ExerciseType;
import com.example.fitnessapp.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/{idUser}/exercisetypes")
public class ExerciseTypeController {

    private final ExerciseTypeService exerciseTypeService;

    @Autowired
    public ExerciseTypeController(ExerciseTypeService exerciseTypeService) {
        this.exerciseTypeService = exerciseTypeService;
    }

    @PostMapping
    public @ResponseBody
    ExerciseType addExerciseType(@Valid @RequestBody ExerciseType exerciseType){
        return exerciseTypeService.addExerciseType(exerciseType);
    }

    @GetMapping("/{id}")
    public ExerciseType getExerciseType(@PathVariable Long id){
        return exerciseTypeService.getExerciseType(id);
    }

    @GetMapping
    public @ResponseBody
    List<ExerciseType> getExerciseTypes(){
        return exerciseTypeService.getExerciseTypes();
    }

    @PutMapping("/{id}")
    public ExerciseType editExerciseType(@PathVariable final Long id, @RequestBody ExerciseType exerciseType) {
        return exerciseTypeService.editExerciseType(id, exerciseType);
    }

    @DeleteMapping("/{id}")
    public ExerciseType deleteExerciseType(@PathVariable final Long id){
        return exerciseTypeService.deleteExerciseType(id);
    }

}
