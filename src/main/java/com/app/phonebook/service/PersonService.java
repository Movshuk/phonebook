package com.app.phonebook.service;

import com.app.phonebook.model.Person;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Map;

public interface PersonService {
    @Secured({"ROLE_ADMIN"})
    List<Person> getAllPersons();
    @Secured({"ROLE_ADMIN"})
    List<Person> findPersonByParams(String firstName);   // throws ResourceNotFoundException;
    @Secured({"ROLE_ADMIN"})
    Map<String, Boolean> deletePersonById(Long id) throws Exception;
    @Secured({"ROLE_ADMIN"})
    Person updatePerson(Person person);
    @Secured({"ROLE_ADMIN"})
    boolean addPerson(Person person);

}
