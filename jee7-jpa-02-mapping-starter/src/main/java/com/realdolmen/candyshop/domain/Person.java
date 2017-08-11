package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    // TODO: make non nullable and restrict to 200 characters

    @Column(nullable = false, length = 200)
    private String firstName;

    // TODO: make non nullable and restrict to 200 characters

    @Column(nullable = false, length = 200)
    private String lastName;

    // TODO: add property birthdate (store only date portion) make it non nullable
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    // TODO: add property age (not stored in database, but calculated from birthdate
    @Transient
    private Long age;

    // TODO: add embedded mapping to address
    @Embedded
    private Address adress;

    // TODO: add element collection (table name "candy_preferences", columns ("candy_color" and "person_id")
    @ElementCollection
    @CollectionTable(name = "candy_preferences")
    @Enumerated(EnumType.STRING)
    @Column(name = "candy_color")
    private List<CandyColor> candyPreferences;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        initializeAge();
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Address getAddress() {
        return adress;
    }

    public void setAddress(Address adress) {
        this.adress = adress;
    }

    public List<CandyColor> getCandyPreferences() {
        return candyPreferences;
    }

    public void setCandyPreferences(List<CandyColor> candyPreferences) {
        this.candyPreferences = candyPreferences;
    }

    public Person() {
    }
}
