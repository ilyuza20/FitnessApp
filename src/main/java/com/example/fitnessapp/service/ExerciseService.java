package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.Exercise;
import com.example.fitnessapp.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise addExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise getExercise(Long id){
        return exerciseRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Exercise deleteExercise(Long id){
        Exercise exercise = getExercise(id);
        exerciseRepository.delete(exercise);
        return exercise;
    }

    public Exercise editExercise(Long id, Exercise exercise){
        Exercise editExercise = getExercise(id);
        editExercise.setName(exercise.getName());
        editExercise.setDescription(exercise.getDescription());
        editExercise.setExerciseTypes(exercise.getExerciseTypes());
        editExercise.setEquipments(exercise.getEquipments());
        exerciseRepository.save(editExercise);
        return editExercise;
    }
}
