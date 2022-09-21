package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.ExerciseType;
import com.example.fitnessapp.entity.WorkoutType;
import com.example.fitnessapp.repository.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkoutTypeService {

    private final WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    public WorkoutTypeService(WorkoutTypeRepository workoutTypeRepository) {
        this.workoutTypeRepository = workoutTypeRepository;
    }

    public WorkoutType addWorkoutType(WorkoutType workoutType) {
        return workoutTypeRepository.save(workoutType);
    }

    public List<WorkoutType> getWorkoutTypes(){
        return workoutTypeRepository.findAll();
    }

    public WorkoutType getWorkoutType(Long id){
        return workoutTypeRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Запись не найдена"));
    }

    public WorkoutType deleteWorkoutType(Long id) {
        WorkoutType workoutType = getWorkoutType(id);
        workoutTypeRepository.delete(workoutType);
        return workoutType;
    }

    public WorkoutType editWorkoutType(Long id, WorkoutType workoutType) {
        WorkoutType editWorkoutType = getWorkoutType(id);
        editWorkoutType.setName(workoutType.getName());
        workoutTypeRepository.save(editWorkoutType);
        return editWorkoutType;
    }

}
