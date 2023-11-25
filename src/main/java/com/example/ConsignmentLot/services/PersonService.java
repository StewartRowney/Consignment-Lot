package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IPersonRepository;
import com.example.ConsignmentLot.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepository repo;

    @Autowired
    public PersonService(IPersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Person> getAllPersons() {
        return repo.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        if (person.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cannot set Person id, set value to null");
        }
        return repo.save(person);
    }

}
