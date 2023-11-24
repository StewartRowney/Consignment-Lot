package com.example.ConsignmentLot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
    @ManyToOne
    private Person owner;

    //Constructors

    public Truck() {}

    public Truck(String name, String model, double askingPrice, Person owner) {
        this.name = name;
        this.model = model;
        this.askingPrice = askingPrice;
        this.owner=owner;
    }

    //Getters

    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public double getAskingPrice() {
        return askingPrice;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }
}
