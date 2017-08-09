package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    public void savePerson(Person person) {
        personRepository.savePerson(person);
    }

    PersonRepository getPersonRepository() {
        return personRepository;
    }

    public Person findPersonById(long id) {
        return personRepository.findPersonById(id);
    }
}
