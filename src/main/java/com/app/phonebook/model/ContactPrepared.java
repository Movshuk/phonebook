package com.app.phonebook.model;

import java.util.List;

public class ContactPrepared {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private List<String> numbers;
    private String contactTypes;

    public ContactPrepared() {
    }

    public ContactPrepared(Long id,
                           String firstName,
                           String lastName,
                           String middleName,
                           String position,
                           List<String> numbers,
                           String contactTypes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.numbers = numbers;
        this.contactTypes = contactTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String getContactTypes() {
        return contactTypes;
    }

    public void setContactTypes(String contactTypes) {
        this.contactTypes = contactTypes;
    }
}
