package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.UserUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TrackedEntityListener {
    @PrePersist
    public void fillInUserCreated(Tracked t) {
        t.setUserCreated(currentUser());
        t.setUserModified(currentUser());
    }

    @PreUpdate
    private void fillInUserModified(Tracked t) {
        t.setUserModified(currentUser());
    }

    private String currentUser() {
        return UserUtils.currentUser();
    }
}
