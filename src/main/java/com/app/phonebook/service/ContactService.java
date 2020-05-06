package com.app.phonebook.service;

import com.app.phonebook.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContact();

    String deleteContactById(Long id);

    Contact updateContact(Contact contact);

    void addContact(Contact contact);

}
