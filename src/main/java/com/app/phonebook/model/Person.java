package com.app.phonebook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "person")
public class Person {

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "middle_name")
    private String middleName;

    @NotBlank
    @Column(name = "position")
    private String position;

    public Person () {

    }

    public Person(@NotBlank String firstName,
                  @NotBlank String lastName,
                  @NotBlank String middleName,
                  @NotBlank String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    public Person(Long id,
                  @NotBlank String firstName,
                  @NotBlank String lastName,
                  @NotBlank String middleName,
                  @NotBlank String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    public void merge(Person personPassed) {
        setId(personPassed.getId());
        setFirstName(personPassed.getFirstName());
        setLastName(personPassed.getLastName());
        setMiddleName(personPassed.getMiddleName());
        setPosition(personPassed.getPosition());
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

    @Override
    public String toString() {
        return firstName + lastName + middleName + position;
    }
}
