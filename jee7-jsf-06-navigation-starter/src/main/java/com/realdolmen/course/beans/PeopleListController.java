package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by cda5732 on 2/03/2017.
 */
@Named
@RequestScoped
public class PeopleListController {
    @EJB
    PersonServiceBean personService;

    private List<Person> people;

    @PostConstruct
    public void init() {
        people = personService.findAll();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void remove(Long personId) {
        personService.remove(personId);
        people = personService.findAll();
    }
}
