package com.realdolmen.candyshop.repositories;

import com.realdolmen.candyshop.domain.Person;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonRepository {
    @Inject
    Logger logger;

    public void savePerson(Person person) {
        logger.info("Saving person");
    }

    public Person findPersonById(long id) {
        logger.info("Retrieving person by id " + id);
        return new Person();
    }
}

