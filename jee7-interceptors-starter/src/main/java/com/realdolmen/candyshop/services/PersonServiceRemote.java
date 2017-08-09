package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;

import java.util.List;

/**
 * Created by cda5732 on 1/03/2017.
 */
public interface PersonServiceRemote {
    Person savePerson(Person person);

    Person findPersonById(long id);

    List<Person> findAllPeople();
}
