package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonServiceRemote;
import com.realdolmen.candyshop.util.DateUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonServiceRemoteIntegrationTest extends AbstractRemoteIntegrationTest {

    private static PersonServiceRemote personService;

    @BeforeClass
    public static void init() throws NamingException {
        personService = lookup("jee7-interceptors-starter/PersonService!com.realdolmen.candyshop.services.PersonServiceRemote");
    }

    @Test
    public void shouldFindAllPeople() throws Exception {
        List<Person> people = personService.findAllPeople();
        assertTrue(people.size() >= 5);
    }

    @Test
    public void shouldSaveAPerson() {
        Person person = new Person();
        person.setFirstName("Theo");
        person.setLastName("Tester");
        person.setBirthDate(DateUtils.createDate("1970-01-01"));
        person = personService.savePerson(person);
        assertNotNull(person.getId());
    }

    @Test
    public void shouldFindAPerson() {
        Person person = personService.findPersonById(1000L);
        assertNotNull(person);
        assertEquals(1000L, person.getId().longValue());
        assertEquals("John", person.getFirstName());
    }
}
