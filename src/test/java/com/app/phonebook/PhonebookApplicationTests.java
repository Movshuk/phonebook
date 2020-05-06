package com.app.phonebook;

import com.app.phonebook.model.Person;
import com.app.phonebook.serviceImpl.PersonServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class PhonebookApplicationTests {
    // *********************** //
    // Test PersonServiceImpl  //
    // *********************** //

    @LocalServerPort
    int serverPort;

    @Autowired
    PersonServiceImpl personServiceImpl;

    @Autowired
    EntityManagerFactory emf;

    @Test
    public void getAllPersonsTest() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:"+serverPort+"/api/phonebook/persons/";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        System.out.println(result.getBody());
    }

    @Test
    public void updatePersonTest() {
        // add test record
        Person personAdded = addTestRecord();
        // change added record
        personAdded.setFirstName("changedFirstName");
        // update record
        Person personUpdated = personServiceImpl.updatePerson(personAdded);
        // test
        Assert.assertEquals(personAdded.toString(), personUpdated.toString());

    }

    @Test
    public void addPersonSimpleTest() {
        Person personTest = new Person("firstName", "lastName", "middleName", "position");
        Assert.assertTrue(personServiceImpl.addPerson(personTest));
    }

    @Test
    public void addPersonTest() {
        // add test record
        Person personExpected = addTestRecord();
        // find added record
        Person personActual = (personServiceImpl.findPersonByParams(personExpected.getFirstName())).get(0);
        // test
        Assert.assertEquals(personActual.toString(), personExpected.toString());
    }

    @Test
    public void deletePersonByIdSuccessTest() throws Exception {
        // add test record
        Person testPerson = addTestRecord();
        Long testId = getIdTestRecord(testPerson);
        // test
        Map<String, Boolean> resultDeleting = personServiceImpl.deletePersonById(testId);
        Assert.assertSame(resultDeleting.get("deleted"), true);
    }

    @Test
    public void deletePersonByIdNegativTest() throws Exception {
        // add test record
        Person testPerson = addTestRecord();
        Long testId = getIdTestRecord(testPerson) + 1L;
        // test
        Map<String, Boolean> resultDeleting = personServiceImpl.deletePersonById(testId);
        Assert.assertSame(resultDeleting.get("not deleted"), false);
    }

    public Person addTestRecord() {
        Person personTest = new Person("firstName", "lastName", "middleName", "position");
        personServiceImpl.addPerson(personTest);
        return personTest;
    }

    public Long getIdTestRecord(Person testPerson) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "select " +"p.id, p.firstName, p.lastName, p.middleName, p.position "
                        +"from Person p " +
                        "where :firstName is null or p.firstName = :firstName");
        query.setParameter("firstName", testPerson.getFirstName());

        Person responsePersonTest = (personServiceImpl.getPersonListFromQuery(query)).get(0);

        return responsePersonTest.getId();
    }


}
