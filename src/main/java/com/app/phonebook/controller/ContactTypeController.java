package com.app.phonebook.controller;

import com.app.phonebook.model.ContactType;
import com.app.phonebook.serviceImpl.ContactTypeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API Description")
public class ContactTypeController {

    @Autowired
    ContactTypeServiceImpl contactTypeServiceImpl;

    @CrossOrigin
    @ApiOperation(value = "Добавить запись", produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added")
    })
    @RequestMapping(value = "/phonebook/contact-types/add", method = RequestMethod.PUT)
    public String addContactTypes(@RequestBody ContactType contactType)
    {
        contactTypeServiceImpl.addContactTypes(contactType);
        return "Successfully added.";

    }

    @CrossOrigin
    @ApiOperation(value = "Получить список всех типов контактов из книги",
            response = ContactType.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received")
    })
    @RequestMapping(value = "/phonebook/contact-types", method = RequestMethod.GET)
    public List<ContactType> getAllContactTypes()
    {

        return contactTypeServiceImpl.getAllContactTypes();
    }

    @CrossOrigin
    @ApiOperation(value = "Удалить запись по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted")
    })
    @RequestMapping(value = "/phonebook/contact-types/{id}/delete", method = RequestMethod.DELETE)
    public String deleteContactTypeById(@PathVariable("id") Long id)
    {
        return contactTypeServiceImpl.deleteContactTypeById(id);
    }


    @CrossOrigin
    @ApiOperation(value = "Редактировать запись типов контактов",
            response = ContactType.class, produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
    })
    @RequestMapping(value = "/phonebook/contact-types/update", method = RequestMethod.POST)
    public ContactType updateContactType(@RequestBody ContactType contactType)
    {

        return contactTypeServiceImpl.updateContactType(contactType);
    }





}
