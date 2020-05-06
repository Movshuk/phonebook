package com.app.phonebook.serviceImpl;

import com.app.phonebook.model.ContactType;
import com.app.phonebook.service.ContactTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {

    final
    EntityManagerFactory emf;

    public ContactTypeServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<ContactType> getAllContactTypes()
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "select " +"ct.id, ct.type "
                        +"from ContactType ct ");

        List<ContactType> contactTypeList =(List<ContactType>)query.getResultList();
        em.close();

        return contactTypeList;
    }

    public String deleteContactTypeById(Long id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.flush();
        em.clear();

        ContactType contactTypeDeleted = em.find(ContactType.class, id);
        em.remove(contactTypeDeleted);

        em.getTransaction().commit();
        em.close();

        return "Deleted";
    }

    @Transactional
    public ContactType updateContactType(ContactType contactTypeReq) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        ContactType contactTypeRes = em.find(ContactType.class, contactTypeReq.getId());
        contactTypeRes.setId(contactTypeReq.getId());
        contactTypeRes.setType(contactTypeReq.getType());

        em.getTransaction().commit();
        em.close();

        return contactTypeRes;

    }

    public void addContactTypes(ContactType contactTypeReq) {
        EntityManager em = emf.createEntityManager();

        ContactType contactTypeRes = new ContactType(
                contactTypeReq.getType()
        );

        em.getTransaction().begin();

        em.persist(contactTypeRes);

        em.getTransaction().commit();
        em.close();
    }

}
