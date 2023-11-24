package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.controllers.PersonController;
import com.example.ConsignmentLot.entities.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    IPersonService mockService = mock(PersonService.class);
    PersonController uut = new PersonController(mockService);

    @Test
    void addPerson() {

        Person person = new Person("Jim", LocalDateTime.MIN);
        uut.addPerson(person);
        verify(mockService, times(1)).addPerson(person);

    }
}