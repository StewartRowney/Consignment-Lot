package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.entities.Truck;
import com.example.ConsignmentLot.services.PersonService;
import com.example.ConsignmentLot.services.IPersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    IPersonService service;

    @Autowired
    public PersonController(IPersonService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @Operation(summary = "Add a person", description = "Add a person")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Person person) {
        return service.addPerson(person);
    }

}
