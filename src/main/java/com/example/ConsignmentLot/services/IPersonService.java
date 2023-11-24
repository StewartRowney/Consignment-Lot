package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.entities.Truck;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPersons();
    Person addPerson(Person person);
    List<Car> getAllCarsByName(String personName);
    List<Truck> getAllTruckByName(String personName);

}
