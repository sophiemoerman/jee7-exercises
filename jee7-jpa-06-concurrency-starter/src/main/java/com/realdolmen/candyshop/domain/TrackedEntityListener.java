package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.UserUtils;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TrackedEntityListener {
    // TODO: add an entity listener method to update userCreated and userModified before saving. Use currentUser()
    @PrePersist
    public void updateUserCreatedAndUserModified(Tracked t ){
        t.setUserCreated(currentUser());
        t.setUserModified(currentUser());
    }

    // TODO: add an entity listener method to update userModified before updating. Use currentUser()
    @PreUpdate
    public void updateUserModified(Tracked t){
        t.setUserModified(currentUser());
    }

    private String currentUser() {
        return UserUtils.currentUser();
    }
}
