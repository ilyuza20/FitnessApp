package com.example.fitnessapp.repository;

import com.example.fitnessapp.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
