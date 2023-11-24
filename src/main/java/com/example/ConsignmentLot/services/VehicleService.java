package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IVehicleRepository;
import com.example.ConsignmentLot.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    private IVehicleRepository repository;

    @Autowired
    public VehicleService(IVehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }
}
