package com.axsos.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.relationships.models.Person;
import com.axsos.relationships.repositories.PersonRepository;



@Service
public class PersonServices {
    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
		this.personRepository = personRepository;
    	
    }

    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public Person createPerson(Person Person) {
        return personRepository.save(Person);
    }


}
