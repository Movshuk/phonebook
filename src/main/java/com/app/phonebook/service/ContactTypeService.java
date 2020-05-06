package com.app.phonebook.service;

import com.app.phonebook.model.ContactType;

import java.util.List;

public interface ContactTypeService {

    List<ContactType> getAllContactTypes();

    String deleteContactTypeById(Long id);

    ContactType updateContactType(ContactType contactType);

    void addContactTypes(ContactType contactType);

}
