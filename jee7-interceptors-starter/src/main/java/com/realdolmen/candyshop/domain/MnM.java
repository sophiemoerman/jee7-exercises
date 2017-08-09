package com.realdolmen.candyshop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("m&m")
public class MnM extends Candy {
    private boolean nuts;

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }
}
