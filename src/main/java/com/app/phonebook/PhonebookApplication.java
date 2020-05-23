package com.app.phonebook;

import com.app.phonebook.model.UserInfo;
import com.app.phonebook.serviceImpl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PhonebookApplication {

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserInfoServiceImpl userInfoServiceImpl;
//
//    @PostConstruct
//    public void init(){
//        UserInfo user = new UserInfo(
//                "admin@admin.ru",
//                passwordEncoder.encode("123"),
//                "ROLE_ADMIN");
//
////         Hibernate
//        if (userInfoServiceImpl.getUserInfoByEmail(user.getEmail()) == null){
//            userInfoServiceImpl.addUserInfo(user);
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(PhonebookApplication.class, args);
    }

}
