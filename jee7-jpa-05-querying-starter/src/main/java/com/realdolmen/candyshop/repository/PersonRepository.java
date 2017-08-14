package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonRepository {

    EntityManager em;

    public Person findPersonById(long id) {
        // TODO: implement this method
        return em.find(Person.class,id);

    }

    public List<Person> findAllPeople() {
           return em.createNamedQuery("find all people", Person.class).getResultList();
    }


    public void savePerson(Person p) {
        // TODO: implement this method
        em.persist(p);

    }

    public void deletePersonById(long id) {
        // TODO: implement this method
        em.remove(em.getReference(Person.class,id));

    }

    public void updatePerson(Person p) {
        // TODO: implement this method
        em.merge(p);


    }

    public long countAllPeople() {
        // TODO: implement this method
        return em.createQuery("select count(p) from Person p",Long.class).getSingleResult();

    }


}
