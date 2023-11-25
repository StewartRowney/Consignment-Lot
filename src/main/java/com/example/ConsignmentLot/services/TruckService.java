package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IVehicleRepository;
import com.example.ConsignmentLot.entities.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService implements ITruckService{

    private final IVehicleRepository vehicleRepository;

    @Autowired
    public TruckService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Truck> getAllTrucks() {
        return vehicleRepository.findAllTrucks();
    }
}
