package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.comparators.VehicleComparator;
import com.example.ConsignmentLot.data.IVehicleRepository;
import com.example.ConsignmentLot.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    private final IVehicleRepository repository;

    @Autowired
    public VehicleService(IVehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = repository.findAll();
        vehicles.sort(new VehicleComparator());
        return vehicles;
    }
}
