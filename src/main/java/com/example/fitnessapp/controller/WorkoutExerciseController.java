package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.entity.WorkoutExercise;
import com.example.fitnessapp.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users/{idUser}/workouts/{idWorkout}/exercises")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    @Autowired
    public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }

    @PostMapping
    public @ResponseBody
    WorkoutExercise addWorkoutExercise(@PathVariable Long idUser, @PathVariable Long idWorkout, @Valid @RequestBody WorkoutExercise workoutExercise){
        return workoutExerciseService.addWorkoutExercise(idUser, idWorkout, workoutExercise);
    }

    @GetMapping("/{id}")
    public WorkoutExercise getWorkoutExercise(@PathVariable Long id){
        return workoutExerciseService.getWorkoutExercise(id);
    }

    @GetMapping
    public @ResponseBody
    List<WorkoutExercise> getWorkoutExercises(){
        return workoutExerciseService.getWorkoutExercises();
    }

    @PutMapping("/{id}")
    public WorkoutExercise editWorkoutExercise(@PathVariable final Long id, @RequestBody WorkoutExercise workoutExercise){
        return workoutExerciseService.editWorkoutExercise(id, workoutExercise);
    }

    @DeleteMapping("/{id}")
    public WorkoutExercise deleteWorkoutExercise(@PathVariable final Long id){
        return workoutExerciseService.deleteWorkoutExercise(id);
    }
}
