package com.realdolmen.candyshop.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Tracked {
    private String userCreated;

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }
}
