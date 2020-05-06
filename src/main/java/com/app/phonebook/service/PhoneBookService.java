package com.app.phonebook.service;

import com.app.phonebook.model.ContactDetail;
import com.app.phonebook.model.ContactPrepared;

import java.util.List;

public interface PhoneBookService {

    void deleteContactById(Long id);
    List<ContactDetail> getContactDetailsById(Long id);
    ContactPrepared getContactPrepared(Long id);
}
