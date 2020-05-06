package com.app.phonebook.serviceImpl;

import com.app.phonebook.model.Contact;
import com.app.phonebook.model.ContactDetail;
import com.app.phonebook.model.ContactPrepared;
import com.app.phonebook.service.PhoneBookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    final
    EntityManagerFactory emf;

    public PhoneBookServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<ContactDetail> getContactDetailsById(Long id)
    {
        EntityManager em = emf.createEntityManager();

        List<ContactDetail> contactDetails = getContactDetailList(em, id);

        return contactDetails;
    }

    public void deleteContactById(Long id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.flush();
        em.clear();

        Contact contactDel = em.find(Contact.class, id);
        em.remove(contactDel);

        em.getTransaction().commit();
        em.close();
    }

    public ContactPrepared getContactPrepared(Long id) {
        // object to response
        ContactPrepared contactPrepared = new ContactPrepared();

        EntityManager em = emf.createEntityManager();

        List<ContactDetail> contactDetails = getContactDetailList(em, id);

        // collect of numbers
        List<String> numbersList = new ArrayList<>(contactDetails.size());

        // set general fields
        contactPrepared.setFirstName(contactDetails.get(0).getFirstName());
        contactPrepared.setLastName(contactDetails.get(0).getLastName());
        contactPrepared.setId(contactDetails.get(0).getId());
        contactPrepared.setMiddleName(contactDetails.get(0).getMiddleName());
        contactPrepared.setPosition(contactDetails.get(0).getPosition());
        contactPrepared.setContactTypes(contactDetails.get(0).getContactType());
        // set group fields
        for(int i = 0; i < contactDetails.size(); i++) {
            numbersList.add(contactDetails.get(i).getNumber());
        }

        contactPrepared.setNumbers(numbersList);

        return contactPrepared;
    }


    // Return join Person - Contact - Contact_type
    public List<ContactDetail> getContactDetailList(EntityManager em, Long id) {

        Query query = em.createQuery(
                "select " +
                        "p.id, p.firstName, p.lastName, p.middleName, p.position, c.number, ct.type "
                        +"from Person p " +
                        "inner join Contact c on p.id = c.personId " +
                        "inner join ContactType ct on ct.id = c.contactTypeId " +
                        "where p.id = :id");

        query.setParameter("id", id);

        List<Object[]> rows = query.getResultList();

        List<ContactDetail> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new ContactDetail(
                    (Long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (String) row[4],
                    (String) row[5],
                    (String) row[6]
                    )
            );
        }
        return result;
    }
}
