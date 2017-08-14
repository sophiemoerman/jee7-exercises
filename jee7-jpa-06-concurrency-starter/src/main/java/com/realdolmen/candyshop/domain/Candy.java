package com.realdolmen.candyshop.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "candy_type")
@NamedQuery(name = "find candy by name like", query = "select c from Candy c where c.name like :myName")
@EntityListeners(TrackedEntityListener.class)
public abstract class Candy extends Tracked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private CandyColor color;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public CandyColor getColor() {
        return color;
    }

    public void setColor(CandyColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }
}
