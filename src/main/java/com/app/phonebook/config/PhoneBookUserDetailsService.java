package com.app.phonebook.config;

import com.app.phonebook.model.UserInfo;
import com.app.phonebook.serviceImpl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService is used to load user-specific data.
 */

@Service
public class PhoneBookUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserInfo activeUserInfo = userInfoServiceImpl.getUserInfoByEmail(email);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
        UserDetails userDetails = (UserDetails)new User(activeUserInfo.getEmail(),
                activeUserInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
