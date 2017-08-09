package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonController {
    @Inject
    PersonService personService;

    PersonService getPersonService() {
        return personService;
    }

    public void savePerson(Person person) {
        personService.savePerson(person);
    }

    public Person findPersonById(long id) {
        return personService.findPersonById(id);
    }
}
