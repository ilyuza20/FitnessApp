package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.entity.WorkoutExercise;
import com.example.fitnessapp.repository.WorkoutExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutService workoutService;
    private final UserService userService;

    @Autowired
    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository, WorkoutService workoutService, UserService userService) {
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.workoutService = workoutService;
        this.userService = userService;
    }

    public WorkoutExercise addWorkoutExercise (Long idUser, Long idWorkout, WorkoutExercise workoutExercise){
        Workout workout = workoutService.getWorkout(idUser, idWorkout);
        workoutExercise.setWorkout(workout);
        return workoutExerciseRepository.save(workoutExercise);
    }

    public List<WorkoutExercise> getWorkoutExercises(){
        //User user = userService.getUserById(idUser);
        //Workout workout = workoutService.getWorkout(user.getId(), workoutService.getWorkout());
        //return workout.getWorkoutExercises();

        //return workoutExerciseRepository.findAllByWorkout(idWorkout);

        return workoutExerciseRepository.findAll();
    }

    public WorkoutExercise getWorkoutExercise(Long id){
        WorkoutExercise workoutExercise = workoutExerciseRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
        return workoutExercise;
    }

    public WorkoutExercise deleteWorkoutExercise(Long id){
        WorkoutExercise workoutExercise = getWorkoutExercise(id);
        workoutExerciseRepository.delete(workoutExercise);
        return workoutExercise;
    }

    public WorkoutExercise editWorkoutExercise(Long id, WorkoutExercise workoutExercise){
        WorkoutExercise editWorkoutExercise = getWorkoutExercise(id);
        editWorkoutExercise.setRep(workoutExercise.getRep());
        editWorkoutExercise.setSet(workoutExercise.getSet());
        editWorkoutExercise.setTime(workoutExercise.getTime());
        editWorkoutExercise.setExercise(workoutExercise.getExercise());
        workoutExerciseRepository.save(editWorkoutExercise);
        return editWorkoutExercise;
    }
}
