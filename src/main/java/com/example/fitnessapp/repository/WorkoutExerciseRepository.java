package com.example.fitnessapp.repository;

import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.entity.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM workout_exercises WHERE workout_id= ?;")
    Set<WorkoutExercise> findAllByWorkout(Long idWorkout);
}
