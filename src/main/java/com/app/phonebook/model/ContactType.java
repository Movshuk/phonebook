package com.app.phonebook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "contact_type")
public class ContactType {

    @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "type")
    private String type;

    public ContactType() {
    }

    public ContactType(@NotBlank String type) {
        this.type = type;
    }

    public ContactType(Long id, @NotBlank String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
