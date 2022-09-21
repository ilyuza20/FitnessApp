package com.example.fitnessapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Enumerated(value = EnumType.STRING)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "exercise_exercise_types",
        joinColumns = @JoinColumn (name = "exercise_id"),
        inverseJoinColumns = @JoinColumn(name = "exercise_type_id"))
    private Set<ExerciseType> exerciseTypes;

    @Enumerated(value = EnumType.STRING)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "exercise_equipments",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipments;

    public Exercise() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ExerciseType> getExerciseTypes() {
        return exerciseTypes;
    }

    public void setExerciseTypes(Set<ExerciseType> exerciseTypes) {
        this.exerciseTypes = exerciseTypes;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }
}
