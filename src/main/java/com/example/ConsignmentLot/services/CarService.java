package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IVehicleRepository;
import com.example.ConsignmentLot.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService implements ICarService{

    private final IVehicleRepository repository;

    @Autowired
    public CarService(IVehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> getAllCars() {
        return repository.findAllCars();
    }
}
