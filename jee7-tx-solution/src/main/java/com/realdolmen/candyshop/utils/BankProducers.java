package com.realdolmen.candyshop.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by cda5732 on 1/03/2017.
 */
public class BankProducers {
    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public EntityManager entityManager() {
        return entityManager;
    }
}
