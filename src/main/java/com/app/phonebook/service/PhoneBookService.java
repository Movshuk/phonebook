package com.app.phonebook.service;

import com.app.phonebook.model.ContactDetail;
import com.app.phonebook.model.ContactPrepared;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface PhoneBookService {

    @Secured ({"ROLE_ADMIN"})
    void deleteContactById(Long id);
    @Secured({"ROLE_ADMIN"})
    List<ContactDetail> getContactDetailsById(Long id);
    @Secured ({"ROLE_ADMIN"})
    ContactPrepared getContactPrepared(Long id);
}
