package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void personCanBePersisted() throws Exception {
        Person person = new Person();
        person.setFirstName("Jane");
        person.setLastName("Doe");
        em.persist(person);
        assertNotNull(person.getId());
    }

    @Test
    public void personCanBeLoaded() throws Exception {
        Person person = em.find(Person.class, 1000L);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }
}
