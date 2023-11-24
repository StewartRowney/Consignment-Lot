package com.example.ConsignmentLot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Person {

    //VARIABLES
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private LocalDateTime dateOfBirth;
    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;

    //CONSTRUCTORS
    public Person() {
    }
    public Person(String name, LocalDateTime dateOfBirth, List<Vehicle> vehicles) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.vehicles = vehicles;
    }
    //GETTERS
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
