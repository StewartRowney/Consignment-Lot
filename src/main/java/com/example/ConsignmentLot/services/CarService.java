package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.comparators.VehicleComparator;
import com.example.ConsignmentLot.data.IVehicleRepository;
import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{

    private final IVehicleRepository repository;

    @Autowired
    public CarService(IVehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = repository.findAllCars();
        cars.sort(new VehicleComparator());
        return cars;
    }
}
