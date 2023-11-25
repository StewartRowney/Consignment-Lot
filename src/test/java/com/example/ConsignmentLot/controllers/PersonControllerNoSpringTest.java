package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.services.IPersonService;
import com.example.ConsignmentLot.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class PersonControllerNoSpringTest {

    private final IPersonService mockService = mock(IPersonService.class);
    private final PersonController uut = new PersonController(mockService);


    @Test
    void test_GetAllPersons_ValidRequest() {
        uut.getAllPersons();
        verify(mockService, times(1)).getAllPersons();
    }

    @Test
    void test_AddPerson_ValidRequest() {

            Person person = new Person("Jim", LocalDateTime.MIN);
            uut.addPerson(person);
            verify(mockService, times(1)).addPerson(person);
    }
}