package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.PersonRepository;
import com.example.ConsignmentLot.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository repo;
    @Autowired
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }


    public List<Person> getAllPersons() {
        return repo.findAll();
    }
}
