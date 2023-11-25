package com.example.ConsignmentLot.entities;

import com.example.ConsignmentLot.entities.enums.VehicleColour;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Truck extends Vehicle{

    //VARIABLES

    //CONSTRUCTORS
    public Truck() {
    }
    public Truck(BigDecimal price, VehicleColour colour, int numberOfSeats, boolean isWorking, Person owner) {
        super(price, colour, numberOfSeats, isWorking, owner);
    }

    //GETTERS


    //SETTERS
}
