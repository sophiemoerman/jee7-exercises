package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candy_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address deliveryAddress;

    @ManyToOne
    private Person person;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.addOrderToHistory(this);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderLine ol : orderLines) {
            total += ol.calculateSubTotal();
        }
        return total;
    }
}
