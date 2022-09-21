package com.example.fitnessapp.repository;

import com.example.fitnessapp.entity.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutTypeRepository extends JpaRepository<WorkoutType, Long> {
}
