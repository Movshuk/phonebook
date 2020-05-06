package com.app.phonebook.service;

import com.app.phonebook.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> getAllPersons();

    List<Person> findPersonByParams(String firstName);   // throws ResourceNotFoundException;

    Map<String, Boolean> deletePersonById(Long id) throws Exception;

    Person updatePerson(Person person);

    boolean addPerson(Person person);

}
