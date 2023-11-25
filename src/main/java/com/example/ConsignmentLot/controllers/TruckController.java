package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Truck;
import com.example.ConsignmentLot.services.ICarService;
import com.example.ConsignmentLot.services.ITruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trucks")
public class TruckController {
    private final ITruckService service;

    @Autowired
    public TruckController(ITruckService service) {
        this.service = service;
    }

    @GetMapping
    public List<Truck> getAllTrucks() {
        return service.getAllTrucks();
    }
}
