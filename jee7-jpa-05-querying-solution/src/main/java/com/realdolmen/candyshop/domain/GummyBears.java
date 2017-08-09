package com.realdolmen.candyshop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gummy_bears")
@DiscriminatorValue("gummy")
public class GummyBears extends Candy {
    private String flavour;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }
}
