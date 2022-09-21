package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    public Workout addWorkout(Long idUser, Workout workout) {
        User user = userService.getUserById(idUser);
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public Set<Workout> getWorkouts(Long idUser){
        User user = userService.getUserById(idUser);
        return user.getWorkouts();
    }

    public Workout getWorkout(Long idUser, Long id){
        return workoutRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
    }

    /*public Workout getWorkoutById(Long id){
        Workout workout =workoutRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
        return workout;
    }*/

    public  Workout deleteWorkout(Long idUser, Long id){
        Workout workout = getWorkout(idUser, id);
        workoutRepository.delete(workout);
        return  workout;
    }

    public Workout editWorkout(Long idUser, Long id, Workout workout){
        Workout editWorkout = getWorkout(idUser, id);
        editWorkout.setName(workout.getName());
        editWorkout.setWorkoutTypes(workout.getWorkoutTypes());
        editWorkout.setWorkoutExercises(workout.getWorkoutExercises());
        workoutRepository.save(editWorkout);
        return editWorkout;
    }
}
