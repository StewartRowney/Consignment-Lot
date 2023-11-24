package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.PersonRepository;
import com.example.ConsignmentLot.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonServiceTest {

    @MockBean
    PersonRepository mockRepo;

    @Autowired
    PersonService uut;

        @Test
        void test_AddPerson_ValidRequest() {
            Person person = new Person("Jim", LocalDateTime.of(2000,10,10,14,55));
            uut.addPerson(person);
            verify(mockRepo, times(1)).save(person);
        }
    }
