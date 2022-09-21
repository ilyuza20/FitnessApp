package com.example.fitnessapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @JsonIgnore
    @NotBlank
    @Enumerated(value = EnumType.STRING)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "workout_workout_types",
            joinColumns = @JoinColumn (name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_type_id"))
    private Set<WorkoutType> workoutTypes;

    @JsonIgnore
    @NotBlank
    @OneToMany(mappedBy = "workout", fetch = FetchType.LAZY)
    private  Set<WorkoutExercise> workoutExercises;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<WorkoutType> getWorkoutTypes() {
        return workoutTypes;
    }

    public void setWorkoutTypes(Set<WorkoutType> workoutTypes) {
        this.workoutTypes = workoutTypes;
    }

    public Set<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(Set<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
