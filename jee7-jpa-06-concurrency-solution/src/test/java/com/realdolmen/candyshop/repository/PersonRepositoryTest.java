package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import com.realdolmen.candyshop.domain.Address;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonRepositoryTest extends AbstractPersistenceTest {
    private PersonRepository repository;

    @Before
    public void initializeRepository() {
        repository = new PersonRepository();
        repository.em = em;
    }

    @Test
    public void findPersonById() throws Exception {
        Person p = repository.findPersonById(2000L);
        assertEquals("Jane", p.getFirstName());
    }

    @Test
    public void savePerson() throws Exception {
        Person p = new Person();
        p.setBirthDate(DateUtils.createDate("2017-02-28"));
        p.setFirstName("Amy");
        p.setLastName("Winehouse");
        p.setAddress(new Address("Vaucampslaan", "42", "Huizingen", "1645"));
        p.setCandyPreferences(new ArrayList<>(Arrays.asList(CandyColor.BLUE, CandyColor.GREEN)));
        repository.savePerson(p);

        flushAndClear();
        Person pp = em.find(Person.class, p.getId());
        assertEquals(DateUtils.createDate("2017-02-28"), pp.getBirthDate());
        assertEquals("Amy", pp.getFirstName());
        assertEquals("Winehouse", pp.getLastName());
        assertEquals("Vaucampslaan 42 1645 Huizingen", pp.getAddress().toString());
        assertEquals(CandyColor.BLUE, pp.getCandyPreferences().get(0));
        assertEquals(CandyColor.GREEN, pp.getCandyPreferences().get(1));

    }

    @Test
    public void findAllPeople() throws Exception {
        List<Person> people = repository.findAllPeople();
        assertEquals(5, people.size());
        assertEquals("Jane", people.get(0).getFirstName());
        assertEquals("John", people.get(1).getFirstName());
        assertEquals("Marcia", people.get(2).getFirstName());
        assertEquals("Tyler", people.get(3).getFirstName());
        assertEquals("Allan", people.get(4).getFirstName());
    }

    @Test
    public void deletePersonById() throws Exception {
        repository.deletePersonById(1000L);
        flushAndClear();
        assertEquals(null, em.find(Person.class, 1000L));
    }

    @Test
    public void updatePerson() throws Exception {
        Person p = em.find(Person.class, 3000L);
        em.detach(p);
        p.setFirstName("Bob");
        flushAndClear();
        repository.updatePerson(p);
        flushAndClear();
        assertEquals("Bob", em.find(Person.class, 3000L).getFirstName());
    }

    @Test
    public void countAllPeople() throws Exception {
        assertEquals(5, repository.countAllPeople());
    }
}
