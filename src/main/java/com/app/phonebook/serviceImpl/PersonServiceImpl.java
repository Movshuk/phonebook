package com.app.phonebook.serviceImpl;

import com.app.phonebook.exceptions.ResourceNotFoundException;
import com.app.phonebook.model.Person;
import com.app.phonebook.service.PersonService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    final
    EntityManagerFactory emf;

    public PersonServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Person> getAllPersons()
    {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "select " +"p.id, p.firstName, p.middleName, p.lastName, p.position "
                        +"from Person p ");

        List<Person> result = getPersonListFromQuery(query);

        em.close();

        return result;
    }

    public List<Person> findPersonByParams(String firstName) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "select " +"p.id, p.firstName,  p.lastName, p.middleName, p.position "
                        +"from Person p " +
                "where :firstName is null or p.firstName = :firstName");

        query.setParameter("firstName", firstName);

        List<Person> result = getPersonListFromQuery(query);

        em.close();

        return result;
    }

    public Map<String, Boolean> deletePersonById(Long id) throws Exception{
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.flush();
        em.clear();

        Map<String, Boolean> response = new HashMap<>();
        Person personToFind = null;

        try {
            personToFind = em.find(Person.class, id);
            if(personToFind == null)
                throw new ResourceNotFoundException("not found");
        } catch(ResourceNotFoundException ex) {      // IllegalArgumentException
            response = new HashMap<>();
            response.put("Record is not deleted.", Boolean.FALSE);
        } finally {

            if(response.isEmpty()) {
                em.remove(personToFind);
                em.getTransaction().commit();
                em.close();
                response.put("Record is deleted.", Boolean.TRUE);
            }
            return response;

        }
    }

    public Person updatePerson(Person personReq) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person perRes = em.find(Person.class, personReq.getId());
        perRes.setId(personReq.getId());
        perRes.setFirstName(personReq.getFirstName());
        perRes.setLastName(personReq.getLastName());
        perRes.setMiddleName(personReq.getMiddleName());
        perRes.setPosition(personReq.getPosition());

        em.getTransaction().commit();
        em.close();

        return perRes;

    }

    public boolean addPerson(Person personReq) {
        EntityManager em = emf.createEntityManager();

        Person personRes = new Person(
                personReq.getFirstName(),
                personReq.getLastName(),
                personReq.getMiddleName(),
                personReq.getPosition()
        );

        em.getTransaction().begin();

        em.persist(personRes);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    public List<Person> getPersonListFromQuery(Query query) {
        List<Object[]> rows = query.getResultList();
        List<Person> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new Person(
                    (Long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (String) row[4]));
        }

        return result;
    }

}
