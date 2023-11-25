package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@SuppressWarnings("UnusedReturnValue")
@RequestMapping("/cars")
public class CarController {
    private final ICarService service;

    @Autowired
    public CarController(ICarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }
}
