package com.realdolmen.candyshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @OneToOne
    private Candy candy;

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public double calculateSubTotal() {
        return candy.getPrice() * quantity;
    }
}
