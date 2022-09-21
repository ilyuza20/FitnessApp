package com.example.fitnessapp.repository;

import com.example.fitnessapp.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
