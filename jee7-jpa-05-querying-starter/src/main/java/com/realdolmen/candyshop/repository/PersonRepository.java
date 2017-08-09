package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonRepository {
    EntityManager em;


    public Person findPersonById(long id) {
        // TODO: implement this method
        return null;
    }

    public List<Person> findAllPeople() {
        // TODO: implement this method
        return null;
    }

    public void savePerson(Person p) {
        // TODO: implement this method
    }

    public void deletePersonById(long id) {
        // TODO: implement this method
    }

    public void updatePerson(Person p) {
        // TODO: implement this method
    }

    public long countAllPeople() {
        // TODO: implement this method
        return 0;
    }

}
