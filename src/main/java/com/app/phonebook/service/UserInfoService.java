package com.app.phonebook.service;

import com.app.phonebook.model.Person;
import com.app.phonebook.model.UserInfo;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface UserInfoService {
//    @Secured({"ROLE_ADMIN"})
    UserInfo getUserInfoByEmail(String email);
}
