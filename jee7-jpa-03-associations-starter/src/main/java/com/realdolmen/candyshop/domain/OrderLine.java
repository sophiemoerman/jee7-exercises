package com.realdolmen.candyshop.domain;

import sun.awt.geom.AreaOp;

import javax.persistence.*;
import java.util.List;

// TODO: make entity with table "oder_line"
@Entity(name = "order_line")
public class OrderLine {
    // TODO: add id (pk, generated) and quantity (int) properties
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    // TODO: add a many to one association to candy
    @ManyToOne
    private Candy candy;

    public double calculateSubTotal() {
        // TODO: implement this method
        return candy.getPrice() * quantity;

    }

    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
