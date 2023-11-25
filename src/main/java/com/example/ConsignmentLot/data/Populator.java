package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Car;
import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.entities.Truck;
import com.example.ConsignmentLot.entities.enums.VehicleColour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Component
@Profile("!test")
public class Populator {
    LocalDateTime dob = LocalDateTime.of(2001,Month.AUGUST,15,10,10);
    private final IPersonRepository IPersonRepository;
    private final IVehicleRepository vehicleRepository;


    @Autowired
    public Populator(IPersonRepository IPersonRepository, IVehicleRepository vehicleRepository1) {
        this.IPersonRepository = IPersonRepository;
        this.vehicleRepository = vehicleRepository1;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void populate(){
        Person p1 = new Person("Stew", LocalDateTime.of(2001,Month.AUGUST,15,10,10));
        Person p2 = new Person("Ayu", LocalDateTime.of(1996,Month.MAY,28,9,10));
        IPersonRepository.save(p1);
        IPersonRepository.save(p2);
        vehicleRepository.save(new Truck(BigDecimal.valueOf(12000), VehicleColour.BLUE, 5, true, p1));
        vehicleRepository.save(new Truck(BigDecimal.valueOf(20000), VehicleColour.BLUE, 5, false, p1));
        vehicleRepository.save(new Car(BigDecimal.valueOf(25000), VehicleColour.RED, 2, true, p1));
        vehicleRepository.save(new Car(BigDecimal.valueOf(2000), VehicleColour.GREEN, 5, false, p2));
    }
}
