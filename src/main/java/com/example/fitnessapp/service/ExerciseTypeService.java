package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.ExerciseType;
import com.example.fitnessapp.entity.WorkoutType;
import com.example.fitnessapp.repository.ExerciseTypeRepository;
import com.example.fitnessapp.repository.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseTypeService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    public ExerciseTypeService(ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    public ExerciseType addExerciseType(ExerciseType exerciseType) {
        return exerciseTypeRepository.save(exerciseType);
    }
    public List<ExerciseType> getExerciseTypes(){
        return exerciseTypeRepository.findAll();
    }

    public ExerciseType getExerciseType(Long id){
        return exerciseTypeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
    }

    public ExerciseType deleteExerciseType(Long id) {
        ExerciseType exerciseType = getExerciseType(id);
        exerciseTypeRepository.delete(exerciseType);
        return exerciseType;
    }

    public ExerciseType editExerciseType(Long id, ExerciseType exerciseType) {
        ExerciseType editExerciseType = getExerciseType(id);
        editExerciseType.setName(exerciseType.getName());
        exerciseTypeRepository.save(editExerciseType);
        return editExerciseType;
    }

}
