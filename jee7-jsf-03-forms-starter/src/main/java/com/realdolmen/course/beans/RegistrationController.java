package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.utils.DateUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by cda5732 on 2/03/2017.
 */

// TODO Make this component session scoped

@Named
@RequestScoped
public class RegistrationController {
    // TODO Initialize the person with a default constructor
    private Person person = new Person("Theo", "Tester", DateUtils.createDate("1970-01-01"));

    // TODO Inject the PersonServiceBean

    public Person getPerson() {
        return person;
    }

    // TODO Add a method that saves the person into the database, clears the person field and navigates back to registration

}
