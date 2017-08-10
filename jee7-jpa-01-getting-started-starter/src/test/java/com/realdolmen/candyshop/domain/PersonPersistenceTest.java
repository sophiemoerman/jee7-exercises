package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


// TODO: use the AbstractPersistence Test
public class PersonPersistenceTest extends AbstractPersistenceTest {

    @Test
    public void testPersist() {
        em.persist(new Person("sophie", "moerman"));
        em.getTransaction().commit();
    }

    @Test
    public void personCanBeLoaded() throws Exception {
        Person person = em.find(Person.class, 1000L);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }
//
//    @Test
//    public void fetchPerson()
//    {
//        Person person = em.createQuery("SELECT p FROM Person p WHERE p.firstName='John'", Person.class).getSingleResult();
//        Assert.assertNotNull(person);
//    }
}
