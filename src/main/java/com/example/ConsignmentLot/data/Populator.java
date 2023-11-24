package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.entities.Vehicle;
import com.example.ConsignmentLot.entities.enums.VehicleColour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Component
public class Populator {
    LocalDateTime dob = LocalDateTime.of(2001,Month.AUGUST,15,10,10);
    private final PersonRepository personRepository;
    private final IVehicleRepository vehicleRepository;

    @Autowired
    public Populator(PersonRepository personRepository, IVehicleRepository vehicleRepository) {
        this.personRepository = personRepository;
        this.vehicleRepository = vehicleRepository;
    }
    @EventListener(ContextRefreshedEvent.class)
    public void populate(){
        Person p1 = new Person("Stew", LocalDateTime.of(2001,Month.AUGUST,15,10,10));
        Person p2 = new Person("Ayu", LocalDateTime.of(1996,Month.MAY,28,9,10));
        personRepository.save(p1);
        personRepository.save(p2);

        Vehicle v1 = new Vehicle(BigDecimal.valueOf(12000), VehicleColour.BLUE, 5, true, p1);
        Vehicle v2 = new Vehicle(BigDecimal.valueOf(25000), VehicleColour.RED, 2, true, p1);
        Vehicle v3 = new Vehicle(BigDecimal.valueOf(2000), VehicleColour.GREEN, 5, false, p2);
        vehicleRepository.save(v1);
        vehicleRepository.save(v2);
        vehicleRepository.save(v3);
    }
}
