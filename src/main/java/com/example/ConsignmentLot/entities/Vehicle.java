package com.example.ConsignmentLot.entities;

import com.example.ConsignmentLot.entities.enums.VehicleColour;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.awt.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Vehicle {

    //VARIABLES
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal price;
    private VehicleColour colour;
    private int numberOfSeats;
    private boolean isWorking;
    @ManyToOne
    private Person owner;

    //CONSTRUCTORS
    public Vehicle() {
    }
    public Vehicle(BigDecimal price, VehicleColour colour, int numberOfSeats, boolean isWorking, Person owner) {
        this.price = price;
        this.colour = colour;
        this.numberOfSeats = numberOfSeats;
        this.isWorking = isWorking;
        this.owner = owner;
    }

    //GETTERS
    public UUID getId() {
        return id;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public VehicleColour getColour() {
        return colour;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public boolean isWorking() {
        return isWorking;
    }
    public Person getOwner() {
        return owner;
    }

    //SETTERS
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setColour(VehicleColour colour) {
        this.colour = colour;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void setWorking(boolean working) {
        isWorking = working;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
