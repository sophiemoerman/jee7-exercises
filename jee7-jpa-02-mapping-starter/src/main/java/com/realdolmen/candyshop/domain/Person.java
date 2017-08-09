package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    // TODO: make non nullable and restrict to 200 characters
    private String firstName;

    // TODO: make non nullable and restrict to 200 characters
    private String lastName;

    // TODO: add property birthdate (store only date portion) make it non nullable

    // TODO: add property age (not stored in database, but calculated from birthdate

    // TODO: add embedded mapping to address

    // TODO: add element collection (table name "candy_preferences", columns ("candy_color" and "person_id")

    @PostLoad
    public void initializeAge() {
        this.age = DateUtils.yearsFrom(birthDate);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
