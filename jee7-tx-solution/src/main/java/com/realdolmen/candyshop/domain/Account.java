package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private int version;

    private String name;

    private BigDecimal balance;

    /**
     * Used by JPA.
     */
    protected Account() {
    }

    public Account(String name) {
        this.name = name;
        this.version = 1;
        this.balance = BigDecimal.ZERO;
    }

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account '%s' has balance €%s", name, balance.toString());
    }

    public void print() {
        System.out.println(toString());
    }
}
