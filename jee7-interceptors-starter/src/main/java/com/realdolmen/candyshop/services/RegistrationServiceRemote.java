package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Remove;

/**
 * Created by cda5732 on 1/03/2017.
 */
public interface RegistrationServiceRemote {
    void addPerson(String firstName, String lastName, String birthDate);

    void addAddress(String street, String number, String city, String postalCode);

    @Remove
    Person registerPerson();
}
