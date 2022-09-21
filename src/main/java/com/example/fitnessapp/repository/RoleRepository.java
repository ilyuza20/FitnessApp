package com.example.fitnessapp.repository;

import com.example.fitnessapp.entity.ERole;
import com.example.fitnessapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
