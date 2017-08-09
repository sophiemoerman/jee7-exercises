package com.realdolmen.candyshop.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class Tracked implements Serializable {
    private String userCreated;
    private String userModified;

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String getUserModified() {
        return userModified;
    }

    public void setUserModified(String userModified) {
        this.userModified = userModified;
    }
}
