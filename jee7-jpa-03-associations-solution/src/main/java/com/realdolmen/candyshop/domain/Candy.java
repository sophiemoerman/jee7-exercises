package com.realdolmen.candyshop.domain;

import javax.persistence.*;

@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private CandyColor color;

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
}
