package com.realdolmen.candyshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AbstractPersistenceTest {
    private static EntityManagerFactory emf;

    protected EntityManager em;

    @BeforeClass
    public static void initializeEntityManagerFactory() {
        // TODO: initialize the EntityManagerFactory
    }

    @Before
    public void initializeEntityManagerWithTransaction() {
        // TODO: initialize the entity manager from the entity manager factory here

        // TODO: begin a transaction
    }

    @After
    public void rollbackTransactionAndCloseEntityManager() {
        // TODO: rollback the transaction
        // TODO: close the entity manager
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        // TODO; close the EntityManagerFactory
    }
}
