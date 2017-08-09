package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.utils.DateUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by cda5732 on 2/03/2017.
 */
@Named
@RequestScoped
public class RegistrationController {
    private Person person = new Person("Theo", "Tester", DateUtils.createDate("1970-01-01"));

    public Person getPerson() {
        return person;
    }
}
