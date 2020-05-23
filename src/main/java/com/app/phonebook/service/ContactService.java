package com.app.phonebook.service;

import com.app.phonebook.model.Contact;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ContactService {
    @Secured({"ROLE_ADMIN"})
    List<Contact> getAllContact();
    @Secured({"ROLE_ADMIN"})
    String deleteContactById(Long id);
    @Secured({"ROLE_ADMIN"})
    Contact updateContact(Contact contact);
    @Secured({"ROLE_ADMIN"})
    void addContact(Contact contact);

}
