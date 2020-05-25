package com.app.phonebook.controller;

import com.app.phonebook.model.ContactDetail;
import com.app.phonebook.model.Person;
import com.app.phonebook.serviceImpl.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "API Description")
public class PersonController {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @CrossOrigin
    @ApiOperation(value = "Добавить запись", produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added")
    })
    @RequestMapping(value = "/phonebook/person/add", method = RequestMethod.POST)
    public String addPerson(@RequestBody Person person)
    {
        personServiceImpl.addPerson(person);
        return "Successfully added";

    }

    @CrossOrigin
    @ApiOperation(value = "Получить список всех абонетов из книги",
            response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received")
    })
    @RequestMapping(value = "/phonebook/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons()
    {
        return personServiceImpl.getAllPersons();
    }

    @CrossOrigin
    @ApiOperation(value = "Получить список всех абонетов из книги по параметрам",
            response = ContactDetail.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received")
    })
    @RequestMapping(value = "/phonebook/persons/search", method = RequestMethod.GET)
    public List<Person> getAllPersons(String firstName)
    {
        return personServiceImpl.findPersonByParams(firstName);
    }

    @CrossOrigin
    @ApiOperation(value = "Удалить запись по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted")
    })
    @RequestMapping(value = "/phonebook/persons/{id}/delete", method = RequestMethod.DELETE)
    public Map<String, Boolean> deletePersonById(@PathVariable("id") Long id) throws Exception {
        return personServiceImpl.deletePersonById(id);
    }

    @CrossOrigin
    @ApiOperation(value = "Редактировать запись об абоненте",
            response = Person.class, produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated")
    })
    @RequestMapping(value = "/phonebook/person/update", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody Person person)
    {

        return personServiceImpl.updatePerson(person);
    }





}
