package com.realdolmen.candyshop.domain;


import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CandyPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void candyCanBePersisted() throws Exception {
        Candy c = new Candy();
        c.setColor(CandyColor.VIOLET);
        em.persist(c);
        assertNotNull(c.getId());
    }

    @Test
    public void candyCanBeLoaded() throws Exception {
        Candy c = em.find(Candy.class, 1000L);
        assertEquals(CandyColor.RED, c.getColor());
    }
}
