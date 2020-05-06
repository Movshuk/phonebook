package com.app.phonebook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "contact")
public class Contact {

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "contact_type_id", insertable = false, updatable = false)
    private ContactType contactType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "contact_type_id")
    private Long contactTypeId;

    @NotBlank
    @Column(name = "number")
    private String number;

    public Contact() {

    }

    public Contact(Long personId,
                   Long contactTypeId,
                   @NotBlank String number) {
        this.personId = personId;
        this.contactTypeId = contactTypeId;
        this.number = number;
    }

    public Contact(Long id,
                   Long personId,
                   Long contactTypeId,
                   @NotBlank String number) {
        this.id = id;
        this.personId = personId;
        this.contactTypeId = contactTypeId;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(Long contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
