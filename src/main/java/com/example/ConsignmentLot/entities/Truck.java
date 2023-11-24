package com.example.ConsignmentLot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Entity
public class Truck{
    //Fields
    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    private String model;
    private double askingPrice;

    //Constructors

    public Truck() {}

    public Truck(String name, String model, double askingPrice) {
        this.name = name;
        this.model = model;
        this.askingPrice = askingPrice;
    }
}
