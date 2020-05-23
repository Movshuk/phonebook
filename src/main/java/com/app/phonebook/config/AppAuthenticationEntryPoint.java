package com.app.phonebook.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * The method rejects every unauthenticated request and sends error code 401.
 */

@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("the authentication page");
    }
}