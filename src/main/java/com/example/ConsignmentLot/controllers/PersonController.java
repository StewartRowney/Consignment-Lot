package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.entities.Truck;
import com.example.ConsignmentLot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/person/{personName}/cars")
    public List<Car> getAllCarsByPersonName(@PathVariable String personName) {
        return service.getAllCarsByName(personName);
    }

    @GetMapping("/person/{personName}/trucks")
    public List<Truck> getAllTrucksByPersonName(@PathVariable String personName) {
        return service.getAllTruckByName(personName);
    }

}
