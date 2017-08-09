package com.realdolmen.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cda5732 on 29/04/2016.
 */
public class PersonList implements Serializable{
    private List<Person> persons = new ArrayList<Person>();

    public void addPerson(Person p) {
        persons.add(p);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
