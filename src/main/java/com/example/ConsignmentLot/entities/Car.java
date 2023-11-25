package com.example.ConsignmentLot.entities;

import com.example.ConsignmentLot.entities.enums.VehicleColour;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Car extends Vehicle{

    //VARIABLES


    //CONSTRUCTORS
    public Car() {
    }
    public Car(BigDecimal price, VehicleColour colour, int numberOfSeats, boolean isWorking, Person owner) {
        super(price, colour, numberOfSeats, isWorking, owner);
    }

    //GETTERS

}
