package com.realdolmen.candyshop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("chocolate")
@Table(name = "chocolate_bar")
public class ChocolateBar extends Candy {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
