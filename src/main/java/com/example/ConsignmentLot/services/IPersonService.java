package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.entities.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPersons();
    Person addPerson(Person person);
}
