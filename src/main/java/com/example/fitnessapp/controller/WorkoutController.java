package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/users/{idUser}/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping
    public @ResponseBody
    Workout addWorkout(@PathVariable Long idUser, @Valid @RequestBody Workout workout){
        return workoutService.addWorkout(idUser, workout);
    }

    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable Long idUser, @PathVariable Long id){
        return workoutService.getWorkout(idUser, id);
    }

    @GetMapping
    public @ResponseBody
    Set<Workout> getWorkouts(@PathVariable Long idUser){
        return workoutService.getWorkouts(idUser);
    }

    @PutMapping("/{id}")
    public Workout editWorkout(@PathVariable Long idUser, @PathVariable final Long id, @RequestBody Workout workout){
        return workoutService.editWorkout(idUser, id, workout);
    }

    @DeleteMapping("/{id}")
    public Workout deleteWorkout(@PathVariable Long idUser, @PathVariable final Long id){
        return workoutService.deleteWorkout(idUser, id);
    }
}
