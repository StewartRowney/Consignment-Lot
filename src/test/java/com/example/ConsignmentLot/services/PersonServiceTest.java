package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IPersonRepository;
import com.example.ConsignmentLot.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceTest {

    @MockBean
    IPersonRepository mockRepo;

    @Autowired
    PersonService uut;

        @Test
        void test_AddPerson_ValidRequest() {
            Person person = new Person("Jim", LocalDateTime.of(2000, Month.MAY, 13, 15, 43));
            uut.addPerson(person);
            verify(mockRepo, times(1)).save(person);
        }
    }
