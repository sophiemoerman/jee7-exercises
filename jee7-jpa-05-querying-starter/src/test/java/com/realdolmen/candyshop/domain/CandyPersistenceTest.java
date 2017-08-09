package com.realdolmen.candyshop.domain;


import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CandyPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void candyCanBePersisted() throws Exception {
        Candy c = new MnM();
        c.setColor(CandyColor.VIOLET);
        em.persist(c);
        assertNotNull(c.getId());
    }

    @Test
    public void candyCanBeLoaded() throws Exception {
        Candy c = em.find(Candy.class, 1000L);
        assertEquals(CandyColor.RED, c.getColor());
    }

    @Test
    public void candyIsPolymorphic() throws Exception {
        Candy candy = em.find(Candy.class, 1000L);
        assertTrue(candy instanceof MnM);
    }

    @Test
    public void personStoresUserCreated() throws Exception {
        Candy c = new ChocolateBar();
        c.setUserCreated("BC65");
        em.persist(c);
        em.flush();
        em.clear();
        assertEquals("BC65", em.find(Candy.class, c.getId()).getUserCreated());
    }
}
