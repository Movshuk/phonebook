package com.app.phonebook.controller;

import com.app.phonebook.model.Contact;
import com.app.phonebook.serviceImpl.ContactServiceImpl;
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
public class ContactController {

    @Autowired
    ContactServiceImpl contactServiceImpl;

    @CrossOrigin
    @ApiOperation(value = "Добавить запись", produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added")
    })
    @RequestMapping(value = "/phonebook/contacts/add", method = RequestMethod.PUT)
    public String addContacts(@RequestBody Contact contact)
    {
        contactServiceImpl.addContact(contact);
        return "Successfully added";

    }

    @CrossOrigin
    @ApiOperation(value = "Получить список всех номеров из книги",
            response = Contact.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Received successfully")
    })
    @RequestMapping(value = "/phonebook/contacts", method = RequestMethod.GET)
    public List<Contact> getAllContacts()
    {

        return contactServiceImpl.getAllContact();
    }

    @CrossOrigin
    @ApiOperation(value = "Удалить запись по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted")
    })
    @RequestMapping(value = "/phonebook/contacts/{id}/delete", method = RequestMethod.DELETE)
    public String deleteContactById(@PathVariable("id") Long id)
    {
        return contactServiceImpl.deleteContactById(id);
    }

    @CrossOrigin
    @ApiOperation(value = "Редактировать запись об абоненте",
            response = Contact.class, produces="application/json", consumes="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated")
    })
    @RequestMapping(value = "/phonebook/contacts/update", method = RequestMethod.POST)
    public Contact updateContact(@RequestBody Contact contact)
    {

        return contactServiceImpl.updateContact(contact);
    }
}
