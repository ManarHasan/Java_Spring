package com.axsos.relationships.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.relationships.models.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
List<Person> findAll();
}

