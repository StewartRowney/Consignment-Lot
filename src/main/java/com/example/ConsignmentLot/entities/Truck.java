package com.example.ConsignmentLot.entities;

import com.example.ConsignmentLot.entities.enums.VehicleColour;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Truck extends Vehicle{

    //VARIABLES
    @Id
    @GeneratedValue
    private UUID id;

    //CONSTRUCTORS
    public Truck() {
    }
    public Truck(BigDecimal price, VehicleColour colour, int numberOfSeats, boolean isWorking, Person owner) {
        super(price, colour, numberOfSeats, isWorking, owner);
    }

    //GETTERS
    public UUID getId() {
        return id;
    }


    //SETTERS
}
