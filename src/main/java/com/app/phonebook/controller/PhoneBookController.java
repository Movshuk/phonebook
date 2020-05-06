package com.app.phonebook.controller;

import com.app.phonebook.model.ContactDetail;
import com.app.phonebook.model.ContactPrepared;
import com.app.phonebook.serviceImpl.PhoneBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "API Description")
public class PhoneBookController {

    @Autowired
    PhoneBookServiceImpl phoneBookServiceImpl;

    @CrossOrigin
    @ApiOperation(value = "Получить детальные данные по id абонента",
            response = ContactDetail.class, responseContainer = "List")
    @RequestMapping(value = "/phonebook/details/{id}", method = RequestMethod.GET)
    public List<ContactDetail> getContactDetailsById(@PathVariable("id") Long id)
    {
        return phoneBookServiceImpl.getContactDetailsById(id);
    }

    @CrossOrigin
    @ApiOperation(value = "Удалить номер контакта по id номера")
    @RequestMapping(value = "/phonebook/details/{id}/delete", method = RequestMethod.DELETE)
    public String deleteContactById(@PathVariable("id") Long id)
    {
        phoneBookServiceImpl.deleteContactById(id);
        return "Запись удалена";
    }

    @CrossOrigin
    @ApiOperation(value = "Получить все данные об абоненте по id абонента",
            response = ContactPrepared.class)
    @RequestMapping(value = "/phonebook/all-details/{id}", method = RequestMethod.GET)
    public ContactPrepared getContactPreparedById(@PathVariable("id") Long id)
    {
        return phoneBookServiceImpl.getContactPrepared(id);
    }




}
