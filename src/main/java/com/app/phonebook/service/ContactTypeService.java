package com.app.phonebook.service;

import com.app.phonebook.model.ContactType;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ContactTypeService {
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<ContactType> getAllContactTypes();
    @Secured({"ROLE_ADMIN"})
    String deleteContactTypeById(Long id);
    @Secured({"ROLE_ADMIN"})
    ContactType updateContactType(ContactType contactType);
    @Secured({"ROLE_ADMIN"})
    void addContactTypes(ContactType contactType);

}
