package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.services.IPersonService;
import com.example.ConsignmentLot.services.PersonService;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

class PersonControllerNoSpringTest {

    IPersonService mockService = mock(PersonService.class);
    PersonController uut = new PersonController(mockService);

    @Test
    void addPerson() {

            Person person = new Person("Jim", LocalDateTime.MIN);
            uut.addPerson(person);
            verify(mockService, times(1)).addPerson(person);
    }
}