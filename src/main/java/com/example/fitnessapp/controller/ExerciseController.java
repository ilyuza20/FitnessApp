package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.Exercise;
import com.example.fitnessapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/{idUser}/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public @ResponseBody
    Exercise addExercise(@Valid @RequestBody Exercise exercise){
        return exerciseService.addExercise(exercise);
    }

    @GetMapping
    public @ResponseBody
    List<Exercise> getExercises(){
        return exerciseService.getExercises();
    }

    @GetMapping("/{id}")
    public Exercise gerExercise(@PathVariable Long id){
        return exerciseService.getExercise(id);
    }

    @PutMapping("/{id}")
    public Exercise editExercise(@PathVariable Long id, @RequestBody Exercise exercise){
        return exerciseService.editExercise(id, exercise);
    }

    @DeleteMapping("/{id}")
    public Exercise deleteExercise(@PathVariable Long id){
        return exerciseService.deleteExercise(id);
    }
}
