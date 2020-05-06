package com.app.phonebook.serviceImpl;

import com.app.phonebook.model.Contact;
import com.app.phonebook.service.ContactService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    final
    EntityManagerFactory emf;

    public ContactServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Contact> getAllContact()
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "select " +"c.id, c.contactTypeId, c.number, c.personId "
                        +"from Contact c ");

        List<Contact> contactList =(List<Contact>)query.getResultList();
        em.close();

        return contactList;
    }

    public String deleteContactById(Long id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.flush();
        em.clear();

        Contact contactDeleted = em.find(Contact.class, id);
        em.remove(contactDeleted);

        em.getTransaction().commit();
        em.close();

        return "Deleted";
    }

    public Contact updateContact(Contact contactRequest) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Contact contactResponse = em.find(Contact.class, contactRequest.getId());

        contactResponse.setId(contactRequest.getId());
        contactResponse.setNumber(contactRequest.getNumber());
        contactResponse.setContactTypeId(contactRequest.getContactTypeId());
        contactResponse.setPersonId(contactRequest.getPersonId());

        em.getTransaction().commit();
        em.close();

        return contactResponse;
    }

    public void addContact(Contact contactRequest) {
        EntityManager em = emf.createEntityManager();

        Contact contactResponse = new Contact(
                contactRequest.getPersonId(),
                contactRequest.getContactTypeId(),
                contactRequest.getNumber()
        );

        em.getTransaction().begin();

        em.persist(contactResponse);

        em.getTransaction().commit();
        em.close();
    }

}
