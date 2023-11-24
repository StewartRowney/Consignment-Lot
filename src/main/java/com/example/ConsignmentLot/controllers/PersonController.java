package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
