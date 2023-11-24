package com.example.ConsignmentLot.comparators;

import com.example.ConsignmentLot.entities.Vehicle;

import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getPrice().compareTo(vehicle2.getPrice());
    }
}