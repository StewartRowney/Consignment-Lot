package com.example.ConsignmentLot.data;

import com.example.ConsignmentLot.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

@Component
public class Populator {
    LocalDateTime dob = LocalDateTime.of(2001,Month.AUGUST,15,10,10);
    PersonRepository personRepository;

    @Autowired
    public Populator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @EventListener(ContextRefreshedEvent.class)
    public void populate(){
        Person p1 = new Person("Stew",dob);
        Person p2 = new Person("Ayu", dob);
        personRepository.save(p1);
        personRepository.save(p2);
    }
}